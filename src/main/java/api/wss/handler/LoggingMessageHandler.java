package api.wss.handler;

import lombok.extern.log4j.Log4j2;

/**
 * @author David
 */
@Log4j2
public class LoggingMessageHandler implements IMessageHandler {

    @Override
    public void handle(String message) {
        log.info(message);
    }

}
