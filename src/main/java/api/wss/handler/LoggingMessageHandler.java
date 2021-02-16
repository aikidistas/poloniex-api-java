package api.wss.handler;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class LoggingMessageHandler implements IMessageHandler {

    @Override
    public void handle(String message) {
        System.out.println(message);
//        log.trace(message);
    }

}
