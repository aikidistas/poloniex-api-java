package org.aikidistas.highfrequencytrading.aeron;

import api.wss.WSSClient;
import api.wss.model.PoloniexWSSSubscription;
import io.aeron.Aeron;
import io.aeron.Publication;
import lombok.extern.log4j.Log4j2;
import org.aikidistas.highfrequencytrading.App;

import java.util.concurrent.TimeUnit;

@Log4j2
public class WssToAeronApp implements App {

    private static final String ENDPOINT_URL = "wss://api2.poloniex.com";
    public static final Aeron.Context AERON_CONTEXT = new Aeron.Context();
    private static final int STREAM_ID = SampleConfiguration.STREAM_ID;
    private static final String CHANNEL = SampleConfiguration.CHANNEL;

    public static void main(String[] args) {
        App app = new WssToAeronApp();
        app.run();

    }

    @Override
    public void run() {
        try {
            new WssToAeronApp().subscribe();
        } catch (InterruptedException ex) {
            log.info(ex.getMessage());
            System.exit(0);
        } catch (Exception ex) {
            log.fatal("An exception occurred when running WssToAeronApp", ex);
            System.exit(-1);
        }

    }

    public void subscribe() throws Exception {
        try (WSSClient wssClient = new WSSClient(ENDPOINT_URL);
             Aeron aeron = Aeron.connect(AERON_CONTEXT);
             Publication publication = aeron.addPublication(CHANNEL, STREAM_ID)
        ) {
            wssClient.addSubscription(PoloniexWSSSubscription.TICKER, new WssToAeronMessageHandler(aeron, publication));
            wssClient.run(TimeUnit.DAYS.toMillis(1));
        }
    }
}
