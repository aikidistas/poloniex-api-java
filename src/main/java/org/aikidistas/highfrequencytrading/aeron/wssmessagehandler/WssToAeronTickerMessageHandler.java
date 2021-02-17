
package org.aikidistas.highfrequencytrading.aeron.wssmessagehandler;

import io.aeron.Publication;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class WssToAeronTickerMessageHandler extends WssToAeronAllMessageHandler {

    public WssToAeronTickerMessageHandler(Publication publication) {
        super(publication);
    }

    @Override
    protected boolean filtered(String message) {
        return !message.startsWith("[1002,null,[");
    }

}
