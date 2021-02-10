package api.rest.publicapi;


import api.rest.HTTPClient;
import api.rest.Json;
import lombok.extern.log4j.Log4j2;
import org.cactoos.scalar.Retry;

import java.io.IOException;
import java.time.Duration;

@Log4j2
public final class PublicApiCommandResultAsJson implements Json {
    private static final String PUBLIC_URL = "https://poloniex.com/public?";
    public static final int RETRY_ATTEMPTS = 10;
    public static final int RETRY_WAIT_MILLIS = 1000;

    private final HTTPClient httpClient;
    private final String command;


    public PublicApiCommandResultAsJson(String command) {
        this(command, new HTTPClient());
    }

    public PublicApiCommandResultAsJson(String command, HTTPClient httpClient) {
        this.command = command;
        this.httpClient = httpClient;
    }

    @Override
    public String json() throws Exception {
        try {
            return new Retry<>(
                    this::resultAsJsonText,
                    RETRY_ATTEMPTS,
                    Duration.ofMillis(RETRY_WAIT_MILLIS)
            ).value();
        } catch (Exception e) {
            final String message = "failed to receive result json from public api call after multiple retries.";
            log.error(message, e);
            throw new Exception(message, e);
        }
    }

    private String resultAsJsonText() throws Exception {
        try {
            String url = PUBLIC_URL + command;
            return httpClient.getHttp(url, null);
        } catch (IOException e) {
            final String message = "Call to '" + command + "' API resulted in exception: - " + e.getMessage();
            log.warn(message, e);
            throw new Exception(message, e);
        }
    }
}
