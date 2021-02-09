package api.rest.publicapi.read.tradehistory;

import api.rest.ApiException;
import api.rest.Json;
import api.rest.publicapi.PublicApiCommandResultAsJson;

import java.time.ZonedDateTime;

class TradeHistoryAsJson implements Json {
    private final Json result;


    TradeHistoryAsJson(String currencyPair, ZonedDateTime start, ZonedDateTime end) {
        this(currencyPair, start.toEpochSecond(), end.toEpochSecond());

    }

    TradeHistoryAsJson(String currencyPair, Long startTimestamp, Long endTimestamp) {
        this(new PublicApiCommandResultAsJson(
                "command=returnTradeHistory&currencyPair=" + currencyPair + "&start=" + startTimestamp.toString() + "&end=" + endTimestamp.toString()
        ));
    }


    TradeHistoryAsJson(Json json) {
        result = json;
    }

    @Override
    public String json() throws ApiException {
        return result.json();
    }
}

