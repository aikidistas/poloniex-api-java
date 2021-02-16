
package org.aikidistas.highfrequencytrading.aeron;

import api.wss.handler.IMessageHandler;
import io.aeron.Aeron;
import io.aeron.Publication;
import org.agrona.BufferUtil;
import org.agrona.concurrent.UnsafeBuffer;

public class WssToAeronMessageHandler implements IMessageHandler {
    public static final Aeron.Context AERON_CONTEXT = new Aeron.Context();
    private static final int STREAM_ID = SampleConfiguration.STREAM_ID;
    private static final String CHANNEL = SampleConfiguration.CHANNEL;
    private final UnsafeBuffer buffer = new UnsafeBuffer(BufferUtil.allocateDirectAligned(256, 64));

    public WssToAeronMessageHandler() {
        System.out.println("Publishing to " + CHANNEL + " on stream id " + STREAM_ID);
    }

    @Override
    public void handle(String message) {

        try (
                Aeron aeron = Aeron.connect(AERON_CONTEXT);
                Publication publication = aeron.addPublication(CHANNEL, STREAM_ID)
        ) {

            final int length = buffer.putStringWithoutLengthAscii(0, message);


            long result = Long.MIN_VALUE;

            while (result <= 0) { // retry until success, or impossible
                result = publication.offer(buffer, 0, length);

                if (result > 0) {
                    System.out.println("yay!");
                } else if (result == Publication.BACK_PRESSURED) {
                    System.out.println("[Retry...]        Offer failed due to back pressure.");
                } else if (result == Publication.NOT_CONNECTED) {
                    System.out.println("[Lost message!!!] Offer failed because publisher is not connected to a subscriber");
                    return;
                } else if (result == Publication.ADMIN_ACTION) {
                    System.out.println("[Retry...]        Offer failed because of an administration action in the system");
                } else if (result == Publication.CLOSED) {
                    System.out.println("[Lost message!!!] Offer failed because publication is closed");
                    return;
                } else if (result == Publication.MAX_POSITION_EXCEEDED) {
                    System.out.println("[Lost message!!!] Offer failed due to publication reaching its max position");
                    return;
                } else {
                    System.out.println("[Lost message!!!] Offer failed due to unknown reason: " + result);
                    return;
                }
            }


            if (!publication.isConnected()) {
                System.out.println("No active subscribers detected");
            }


        }
    }

}
