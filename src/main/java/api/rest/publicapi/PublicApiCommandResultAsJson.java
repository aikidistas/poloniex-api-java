package api.rest.publicapi;

import api.rest.ApiReadException;
import api.rest.HTTPClient;
import api.rest.Json;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;

@Log4j2
public final class PublicApiCommandResultAsJson implements Json {
    private static final String PUBLIC_URL = "https://poloniex.com/public?";

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
    public String json() throws ApiReadException {
        try {
            String url = PUBLIC_URL + command;
            return httpClient.getHttp(url, null);
        } catch (IOException ex) {
            log.warn("Call to '" + command + "' API resulted in exception: - " + ex.getMessage(), ex);
            throw new ApiReadException(ex);
        }
    }
}
