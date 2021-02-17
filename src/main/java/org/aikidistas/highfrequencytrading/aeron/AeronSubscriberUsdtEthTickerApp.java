package org.aikidistas.highfrequencytrading.aeron;

import io.aeron.Aeron;
import io.aeron.FragmentAssembler;
import io.aeron.Image;
import io.aeron.Subscription;
import io.aeron.logbuffer.FragmentHandler;
import lombok.extern.log4j.Log4j2;
import org.agrona.concurrent.IdleStrategy;
import org.agrona.concurrent.SigInt;
import org.aikidistas.highfrequencytrading.App;
import org.aikidistas.highfrequencytrading.aeron.aeronfragmenthandler.PrintAsciUsdtEthTickerMessageFragmentHandler;
import org.aikidistas.highfrequencytrading.aeron.config.SampleConfiguration;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;

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
public class AeronSubscriberUsdtEthTickerApp implements App {
    private static final int STREAM_ID = SampleConfiguration.STREAM_ID;
    private static final String CHANNEL = SampleConfiguration.CHANNEL;
    private static final int FRAGMENT_COUNT_LIMIT = SampleConfiguration.FRAGMENT_COUNT_LIMIT;

    private final Aeron.Context aeronContext = new Aeron.Context()
            .availableImageHandler(AeronSubscriberUsdtEthTickerApp::printAvailableImage)
            .unavailableImageHandler(AeronSubscriberUsdtEthTickerApp::printUnavailableImage);

    public static void main(final String[] args) {
        App app = new AeronSubscriberUsdtEthTickerApp();
        app.run();
    }

    /**
     * Return a reusable, parametrised event loop that calls and idler when no messages are received.
     *
     * @param fragmentHandler to be called back for each message.
     * @param limit           passed to {@link Subscription#poll(FragmentHandler, int)}.
     * @param running         indication for loop.
     * @param idleStrategy    to use for loop.
     * @return loop function.
     */
    public static Consumer<Subscription> subscriberLoop(
            final FragmentHandler fragmentHandler,
            final int limit,
            final AtomicBoolean running,
            final IdleStrategy idleStrategy) {
        return
                (subscription) ->
                {
                    final FragmentAssembler assembler = new FragmentAssembler(fragmentHandler);
                    while (running.get()) {
                        final int fragmentsRead = subscription.poll(assembler, limit);
                        idleStrategy.idle(fragmentsRead);
                    }
                };
    }

    /**
     * Print the information for an available image to stdout.
     *
     * @param image that has been created.
     */
    private static void printAvailableImage(final Image image) {
        final Subscription subscription = image.subscription();
        System.out.printf(
                "Available image on %s streamId=%d sessionId=%d from %s%n",
                subscription.channel(), subscription.streamId(), image.sessionId(), image.sourceIdentity());
    }

    /**
     * Print the information for an unavailable image to stdout.
     *
     * @param image that has gone inactive.
     */
    private static void printUnavailableImage(final Image image) {
        final Subscription subscription = image.subscription();
        System.out.printf(
                "Unavailable image on %s streamId=%d sessionId=%d%n",
                subscription.channel(), subscription.streamId(), image.sessionId());
    }

    @Override
    public void run() {
        System.out.println("Subscribing to " + CHANNEL + " on stream id " + STREAM_ID);

        final FragmentHandler fragmentHandler = new PrintAsciUsdtEthTickerMessageFragmentHandler();
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
            subscriberLoop(fragmentHandler, FRAGMENT_COUNT_LIMIT, running).accept(subscription);

            System.out.println("Shutting down...");
        }
    }

    /**
     * Return a reusable, parametrised event loop that calls a default {@link IdleStrategy} when no messages
     * are received.
     *
     * @param fragmentHandler to be called back for each message.
     * @param limit           passed to {@link Subscription#poll(FragmentHandler, int)}.
     * @param running         indication for loop.
     * @return loop function.
     */
    private Consumer<Subscription> subscriberLoop(
            final FragmentHandler fragmentHandler, final int limit, final AtomicBoolean running) {
        return subscriberLoop(fragmentHandler, limit, running, SampleConfiguration.newIdleStrategy());
    }
}
