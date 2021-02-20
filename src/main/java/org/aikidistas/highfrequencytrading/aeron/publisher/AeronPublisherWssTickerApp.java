package org.aikidistas.highfrequencytrading.aeron.publisher;

import api.wss.WSSClient;
import api.wss.model.PoloniexWSSSubscription;
import io.aeron.Aeron;
import io.aeron.Publication;
import lombok.extern.log4j.Log4j2;
import org.aikidistas.highfrequencytrading.App;
import org.aikidistas.highfrequencytrading.aeron.config.SampleConfiguration;
import org.aikidistas.highfrequencytrading.aeron.wssmessagehandler.WssToAeronTickerMessageHandler;

import java.util.concurrent.TimeUnit;

@Log4j2
public class AeronPublisherWssTickerApp implements App {

    private static final String ENDPOINT_URL = "wss://api2.poloniex.com";
    private static final int STREAM_ID = SampleConfiguration.STREAM_ID;
    private static final String CHANNEL = SampleConfiguration.CHANNEL;
    private final Aeron.Context AERON_CONTEXT = new Aeron.Context();

    public static void main(String[] args) {
        App app = new AeronPublisherWssTickerApp();
        app.run();
    }

    @Override
    public void run() {
        try {
            new AeronPublisherWssTickerApp().subscribe();
        } catch (InterruptedException ex) {
            log.info(ex.getMessage());
            System.exit(0);
        } catch (Exception ex) {
            log.fatal("An exception occurred when running WssToAeronApp", ex);
            System.exit(-1);
        }
    }

    public void subscribe() throws Exception {
        try (Aeron aeron = Aeron.connect(AERON_CONTEXT);
             Publication publication = aeron.addPublication(CHANNEL, STREAM_ID)
        ) {
            while (true) {
                try (WSSClient wssClient = new WSSClient(ENDPOINT_URL)) {
                    wssClient.addSubscription(PoloniexWSSSubscription.TICKER, new WssToAeronTickerMessageHandler(publication));
                    wssClient.run(TimeUnit.MINUTES.toMillis(1));
                    // todo: throw exception when heartbeat or other message not received for 2 sec

                } catch (WssDisconnectedException e) {
                    // reconnect
                    // todo: do not use WssDisconnectedException exception for flow control
                } catch (InterruptedException ex) {
                    // reconnect
                    // todo: remove this temporary 1 min restarting hack/fix when added WssDisconnectedException throwing
                }
            }
        }
    }
}
