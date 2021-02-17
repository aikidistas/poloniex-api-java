package org.aikidistas.highfrequencytrading.aeron;

import io.aeron.Aeron;
import io.aeron.Subscription;
import io.aeron.logbuffer.FragmentHandler;
import lombok.extern.log4j.Log4j2;
import org.agrona.concurrent.SigInt;
import org.aikidistas.highfrequencytrading.App;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * This is a Basic Aeron subscriber application.
 * <p>
 * The application subscribes to a default channel and stream ID. These defaults can
 * be overwritten by changing their value in {@link SampleConfiguration} or by
 * setting their corresponding Java system properties at the command line, e.g.:
 * -Daeron.sample.channel=aeron:udp?endpoint=localhost:5555 -Daeron.sample.streamId=20
 * This application only handles non-fragmented data. A DataHandler method is called
 * for every received message or message fragment.
 * For an example that implements reassembly of large, fragmented messages, see
 * {@link MultipleSubscribersWithFragmentAssembly}.
 */
@Log4j2
public class AeronSubscriberApp implements App {
    private static final int STREAM_ID = SampleConfiguration.STREAM_ID;
    private static final String CHANNEL = SampleConfiguration.CHANNEL;
    private static final int FRAGMENT_COUNT_LIMIT = SampleConfiguration.FRAGMENT_COUNT_LIMIT;
    private static final boolean EMBEDDED_MEDIA_DRIVER = SampleConfiguration.EMBEDDED_MEDIA_DRIVER;


    private final Aeron.Context aeronContext = new Aeron.Context()
            .availableImageHandler(SamplesUtil::printAvailableImage)
            .unavailableImageHandler(SamplesUtil::printUnavailableImage);

    public static void main(final String[] args) {
        App app = new AeronSubscriberApp();
        app.run();

    }

    @Override
    public void run() {
        System.out.println("Subscribing to " + CHANNEL + " on stream id " + STREAM_ID);

        final FragmentHandler fragmentHandler = SamplesUtil.printAsciiMessage(STREAM_ID);
        final AtomicBoolean running = new AtomicBoolean(true);

        // Register a SIGINT handler for graceful shutdown.
        SigInt.register(() -> running.set(false));

        // Create an Aeron instance using the configured Context and create a
        // Subscription on that instance that subscribes to the configured
        // channel and stream ID.
        // The Aeron and Subscription classes implement "AutoCloseable" and will automatically
        // clean up resources when this try block is finished
        try (Aeron aeron = Aeron.connect(aeronContext);
             Subscription subscription = aeron.addSubscription(CHANNEL, STREAM_ID)) {
            SamplesUtil.subscriberLoop(fragmentHandler, FRAGMENT_COUNT_LIMIT, running).accept(subscription);

            System.out.println("Shutting down...");
        }
    }


}
