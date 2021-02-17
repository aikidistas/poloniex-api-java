package org.aikidistas.highfrequencytrading.aeron.aeronfragmenthandler;

import io.aeron.logbuffer.FragmentHandler;
import io.aeron.logbuffer.Header;
import org.agrona.DirectBuffer;

/**
 * Subscription data handler function that prints the message contents.
 */
public class PrintAsciUsdtEthTickerMessageFragmentHandler implements FragmentHandler {
    @Override
    public void onFragment(DirectBuffer buffer, int offset, int length, Header header) {
        final String msg = buffer.getStringWithoutLengthAscii(offset, length);
        if (filtered(msg)) {
            return;
        }
        System.out.println(msg);
    }

    protected boolean filtered(String message) {
        return !message.startsWith("[1002,null,[149,");
    }
}
