package org.aikidistas.highfrequencytrading.aeron;

import api.wss.WSSClient;
import api.wss.handler.LoggingMessageHandler;
import api.wss.model.PoloniexWSSSubscription;
import lombok.extern.log4j.Log4j2;

/**
 * @author David
 */
@Log4j2
public class PoloniexWSSClient {

    private static final String ENDPOINT_URL = "wss://api2.poloniex.com";

    public static void main(String[] args) {
        try {
            new PoloniexWSSClient().subscribe();
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
//            wssClient.addSubscription(PoloniexWSSSubscription.TICKER, new WssToAeronMessageHandler());
            wssClient.addSubscription(PoloniexWSSSubscription.TICKER, new LoggingMessageHandler());
//            wssClient.run(Long.MAX_VALUE/2);
            wssClient.run(60000);
        }

    }
}
