package api.rest.privateapi.read.tradehistory;

import api.rest.ApiException;
import api.rest.Json;
import api.rest.privateapi.PrivateApiResultAsJson;
import com.jcabi.aspects.RetryOnFailure;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

class TradeHistoryPrivateAsJson implements Json {
    private static final String COMMAND = "returnTradeHistory";
    private final Json result;

// TODO: move this functionality to separate decarating class TradeHistoryAllMarkets. which will return other result type Map<String, List<TradeHistoryDto></TradeHistoryDto>>
//    TradeHistoryPrivateAsJson() {
//        this("all");
//    }

    TradeHistoryPrivateAsJson(String currencyPair) {
        List<NameValuePair> additionalPostParams = new ArrayList<>();
        additionalPostParams.add(new BasicNameValuePair("currencyPair", currencyPair));
        result = new PrivateApiResultAsJson(COMMAND, additionalPostParams);
    }

    TradeHistoryPrivateAsJson(String currencyPair, ZonedDateTime start, ZonedDateTime end) {
        this(currencyPair, start.toEpochSecond(), end.toEpochSecond());
    }

    TradeHistoryPrivateAsJson(String currencyPair, long start, long end) {
        List<NameValuePair> additionalPostParams = new ArrayList<>();
        additionalPostParams.add(new BasicNameValuePair("currencyPair", currencyPair));
        additionalPostParams.add(new BasicNameValuePair("start", String.valueOf(start)));
        additionalPostParams.add(new BasicNameValuePair("end", String.valueOf(end)));
        result = new PrivateApiResultAsJson(COMMAND, additionalPostParams);
    }

    @RetryOnFailure
    @Override
    public String json() throws ApiException {
        return result.json();
    }
}
