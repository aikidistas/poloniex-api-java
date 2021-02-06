package org.aikidistas.example;

import api.wss.WSSClient;
import api.wss.handler.LoggingMessageHandler;
import api.wss.model.PoloniexWSSSubscription;
import lombok.extern.log4j.Log4j2;

/**
 *
 * @author David
 */
@Log4j2
public class PoloniexWSSClientExample {

    private static final String ENDPOINT_URL = "wss://api2.poloniex.com";

    public static void main(String[] args) {
        try {
            new PoloniexWSSClientExample().subscribe();
        } catch (InterruptedException ex) {
            log.info(ex.getMessage());
            System.exit(0);
        } catch (Exception ex) {
            log.fatal("An exception occurred when running PoloniexWSSClientExample - {}", ex.getMessage());
            System.exit(-1);
        }
    }

    public void subscribe() throws Exception {
        try (WSSClient wssClient = new WSSClient(ENDPOINT_URL)) {
            wssClient.addSubscription(PoloniexWSSSubscription.TICKER, new LoggingMessageHandler());
//            wssClient.addSubscription(PoloniexWSSSubscription.TICKER, new TickerMessageHandler());
            wssClient.run(60000);
        }

    }
}
