package api.wss;

import api.wss.handler.IMessageHandler;
import api.wss.handler.LoggingMessageHandler;
import com.google.gson.Gson;
import io.netty.channel.*;
import io.netty.handler.codec.http.DefaultHttpHeaders;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.websocketx.*;
import io.netty.util.CharsetUtil;
import lombok.extern.log4j.Log4j2;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

@Log4j2
public class PoloniexWSSClientRouter extends SimpleChannelInboundHandler<Object> {

    private static final int MAX_FRAME_LENGTH = 1262144;

    private final WebSocketClientHandshaker handshaker;
    private ChannelPromise handshakeFuture;
    private boolean running;

    private Map<Double, IMessageHandler> subscriptions;
    private final IMessageHandler defaultSubscriptionMessageHandler;
    private final Gson gson;

    public PoloniexWSSClientRouter(URI url, Map<Double, IMessageHandler> subscriptions) throws URISyntaxException {
        this(WebSocketClientHandshakerFactory
                .newHandshaker(url, WebSocketVersion.V13, null, true, new DefaultHttpHeaders(), MAX_FRAME_LENGTH), subscriptions);
    }

    public PoloniexWSSClientRouter(WebSocketClientHandshaker handshaker, Map<Double, IMessageHandler> subscriptions) {
        this.handshaker = handshaker;
        this.subscriptions = subscriptions;
        this.defaultSubscriptionMessageHandler = new LoggingMessageHandler();
        this.gson = new Gson();
    }

    public ChannelFuture handshakeFuture() {
        return handshakeFuture;
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) {
        handshakeFuture = ctx.newPromise();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        handshaker.handshake(ctx.channel());
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        log.trace("WebSocket Client disconnected!");
    }

    @Override
    public void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        Channel ch = ctx.channel();
        if (!handshaker.isHandshakeComplete()) {
            try {
                handshaker.finishHandshake(ch, (FullHttpResponse) msg);
                running = true;
                log.trace("WebSocket Client connected!");
                handshakeFuture.setSuccess();
            } catch (WebSocketHandshakeException e) {
                log.trace("WebSocket Client failed to connect");
                running = false;
                handshakeFuture.setFailure(e);
            }
            return;
        }

        if (msg instanceof FullHttpResponse) {
            FullHttpResponse response = (FullHttpResponse) msg;
            throw new IllegalStateException("Unexpected FullHttpResponse (getStatus=" + response.status() + ", content="
                    + response.content().toString(CharsetUtil.UTF_8) + ')');
        }

        WebSocketFrame frame = (WebSocketFrame) msg;
        if (frame instanceof TextWebSocketFrame) {
            TextWebSocketFrame textFrame = (TextWebSocketFrame) frame;
            log.trace("WebSocket Client received message: " + textFrame.text());

//            List results = this.gson.fromJson(textFrame.text(), List.class); // TODO: handle wrong conversion. Expected BEGIN_ARRAY but was BEGIN_OBJECT
//            this.subscriptions.getOrDefault(results.get(0), this.defaultSubscriptionMessageHandler).handle(textFrame.text());
            this.subscriptions.values().forEach(handler -> handler.handle(textFrame.text()));

        } else if (frame instanceof CloseWebSocketFrame) {
            log.trace("WebSocket Client received closing");
            running = false;
            ch.close();
        }

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        log.error(cause);
        if (!handshakeFuture.isDone()) {
            handshakeFuture.setFailure(cause);
        }
        running = false;
        ctx.close();
    }

    public boolean isRunning() {
        return running;
    }
}
