package org.aikidistas.highfrequencytrading.aeron.transformer;

import io.aeron.Aeron;
import io.aeron.Publication;
import io.aeron.Subscription;
import io.aeron.logbuffer.BufferClaim;
import io.aeron.logbuffer.FragmentHandler;
import io.aeron.logbuffer.Header;
import lombok.extern.log4j.Log4j2;
import org.agrona.BufferUtil;
import org.agrona.DirectBuffer;
import org.agrona.concurrent.BusySpinIdleStrategy;
import org.agrona.concurrent.IdleStrategy;
import org.agrona.concurrent.SigInt;
import org.agrona.concurrent.UnsafeBuffer;
import org.aikidistas.highfrequencytrading.App;
import org.aikidistas.highfrequencytrading.aeron.config.SampleConfiguration;

import java.util.concurrent.atomic.AtomicBoolean;

@Log4j2
public class AeronTransformerUsdtEthTickerToLastPriceApp implements App {
    private static final int PING_STREAM_ID = SampleConfiguration.STREAM_ID;
    private static final int PONG_STREAM_ID = SampleConfiguration.STREAM_ID;
    private static final int FRAME_COUNT_LIMIT = SampleConfiguration.FRAGMENT_COUNT_LIMIT;
    private static final String PING_CHANNEL = SampleConfiguration.CHANNEL;
    private static final String PONG_CHANNEL = SampleConfiguration.CHANNEL;

    private static final IdleStrategy PING_HANDLER_IDLE_STRATEGY = new BusySpinIdleStrategy();

    public static void main(final String[] args) {
        App app = new AeronTransformerUsdtEthTickerToLastPriceApp();
        app.run();
    }

    private static void pingHandler(
            final BufferClaim bufferClaim,
            final Publication pongPublication,
            final DirectBuffer buffer,
            final int offset,
            final int length,
            final Header header) {
        PING_HANDLER_IDLE_STRATEGY.reset();
        while (pongPublication.tryClaim(length, bufferClaim) <= 0) {
            PING_HANDLER_IDLE_STRATEGY.idle();
        }

        bufferClaim
                .flags(header.flags())
                .putBytes(buffer, offset, length)
                .commit();
    }

    @Override
    public void run() {
        final Aeron.Context aeronContext = new Aeron.Context();

//        aeronContext.availableImageHandler(SamplesUtil::printAvailableImage);
//        aeronContext.unavailableImageHandler(SamplesUtil::printUnavailableImage);

        final IdleStrategy idleStrategy = new BusySpinIdleStrategy();

        System.out.println("Subscribing Ping at " + PING_CHANNEL + " on stream id " + PING_STREAM_ID);
        System.out.println("Publishing Pong at " + PONG_CHANNEL + " on stream id " + PONG_STREAM_ID);

        final AtomicBoolean running = new AtomicBoolean(true);
        SigInt.register(() -> running.set(false));

        try (Aeron aeron = Aeron.connect(aeronContext);
             Subscription subscription = aeron.addSubscription(PING_CHANNEL, PING_STREAM_ID);
             Publication publication = aeron.addPublication(PONG_CHANNEL, PONG_STREAM_ID)) {


            // ping
            final BufferClaim bufferClaim = new BufferClaim();
            final FragmentHandler fragmentHandler = (buffer, offset, length, header) -> {
                //pingHandler(bufferClaim, publication, buffer, offset, length, header);

                String inMessage = buffer.getStringWithoutLengthAscii(offset, length);
                if (inMessage.startsWith("{test}")) {
                    return;
                }

                // publisher
                final UnsafeBuffer outputBuffer = new UnsafeBuffer(BufferUtil.allocateDirectAligned(256, 64));
                //            final int length = outputBuffer.putStringWithoutLengthAscii(0, message());
                final int lengthOutput = outputBuffer.putStringWithoutLengthAscii(0, "{test}" + inMessage);


                while (publication.offer(outputBuffer, 0, lengthOutput) <= 0) ;

            };

            while (running.get()) {
                idleStrategy.idle(subscription.poll(fragmentHandler, FRAME_COUNT_LIMIT));
            }

            System.out.println("Shutting down...");
        }
    }
}
