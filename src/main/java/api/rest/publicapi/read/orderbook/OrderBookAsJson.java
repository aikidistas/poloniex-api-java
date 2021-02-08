package api.rest.publicapi.read.orderbook;

import api.rest.ApiException;
import api.rest.Json;
import api.rest.publicapi.PublicApiCommandResultAsJson;
import com.jcabi.aspects.RetryOnFailure;

class OrderBookAsJson implements Json {
    private static final int DEFAULT_DEPTH = 50;
    private final Json result;

    OrderBookAsJson(String currencyPair, int depth) {
        this(new PublicApiCommandResultAsJson(
                "command=returnOrderBook&currencyPair=" + currencyPair + "&depth=" + depth
        ));
    }

    OrderBookAsJson(String currencyPair) {
        this(currencyPair, DEFAULT_DEPTH);
    }

    OrderBookAsJson(Json json) {
        result = json;
    }

    @RetryOnFailure
    @Override
    public String json() throws ApiException {
        return result.json();
    }
}
