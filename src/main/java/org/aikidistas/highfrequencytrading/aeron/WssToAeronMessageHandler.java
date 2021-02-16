
package org.aikidistas.highfrequencytrading.aeron;

import api.wss.handler.IMessageHandler;
import api.wss.handler.TickerUsdtEthMessageHandler;
import api.wss.model.PoloniexWSSTickerDto;
import io.aeron.Aeron;
import io.aeron.Publication;
import lombok.extern.log4j.Log4j2;
import org.agrona.BufferUtil;
import org.agrona.concurrent.UnsafeBuffer;

import java.util.Objects;

@Log4j2
public class WssToAeronMessageHandler implements IMessageHandler {
    //    private final UnsafeBuffer buffer = new UnsafeBuffer(BufferUtil.allocateDirectAligned(256, 64));
    private final UnsafeBuffer buffer = new UnsafeBuffer(BufferUtil.allocateDirectAligned(512, 64));

    private final Aeron aeron;
    private final Publication publication;

    public WssToAeronMessageHandler(Aeron aeron, Publication publication) {
        this.aeron = aeron;
        this.publication = publication;

        log.info("AERON. Publishing to " + publication.channel() + " on stream id " + publication.streamId());
    }

    @Override
    public void handle(String message) {
        PoloniexWSSTickerDto tickerDto = TickerUsdtEthMessageHandler.mapMessageToPoloniexTicker(message);
        if (Objects.isNull(tickerDto)) {
            return;
        }

        final int length = buffer.putStringWithoutLengthAscii(0, tickerDto.toString());


        long result = Long.MIN_VALUE;

        while (result <= 0) { // retry until success, or impossible
            result = publication.offer(buffer, 0, length);

            if (result > 0) {
                log.info("yay!");
            } else if (result == Publication.BACK_PRESSURED) {
                log.warn("[Retry...]        Offer failed due to back pressure.");
            } else if (result == Publication.NOT_CONNECTED) {
                log.error("[Lost message!!!] Offer failed because publisher is not connected to a subscriber");
                return;
            } else if (result == Publication.ADMIN_ACTION) {
                log.warn("[Retry...]        Offer failed because of an administration action in the system");
            } else if (result == Publication.CLOSED) {
                log.error("[Lost message!!!] Offer failed because publication is closed");
                return;
            } else if (result == Publication.MAX_POSITION_EXCEEDED) {
                log.error("[Lost message!!!] Offer failed due to publication reaching its max position");
                return;
            } else {
                log.error("[Lost message!!!] Offer failed due to unknown reason: " + result);
                return;
            }
        }


        if (!publication.isConnected()) {
            System.out.println("No active subscribers detected");
        }
    }

}
