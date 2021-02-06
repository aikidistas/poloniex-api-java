package api.rest.privateapi.trade.sell;

import api.rest.ApiException;
import api.rest.Json;
import api.rest.privateapi.PrivateApiResultAsJson;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

class PoloniexSellOrderAsJson implements Json {
    private static final String COMMAND = "sell";
    private final Json result;

    PoloniexSellOrderAsJson(String currencyPair, BigDecimal rate, BigDecimal amount) {
        this(currencyPair, rate, amount, false, false, false);
    }

    PoloniexSellOrderAsJson(String currencyPair, BigDecimal rate, BigDecimal amount, boolean fillOrKill, boolean immediateOrCancel, boolean postOnly) {
        List<NameValuePair> additionalPostParams = new ArrayList<>();
        additionalPostParams.add(new BasicNameValuePair("currencyPair", currencyPair));
        additionalPostParams.add(new BasicNameValuePair("rate", rate.toPlainString()));
        additionalPostParams.add(new BasicNameValuePair("amount", amount.toPlainString()));
        additionalPostParams.add(new BasicNameValuePair("fillOrKill", fillOrKill ? "1" : "0"));
        additionalPostParams.add(new BasicNameValuePair("immediateOrCancel", immediateOrCancel ? "1" : "0"));
        additionalPostParams.add(new BasicNameValuePair("postOnly", postOnly ? "1" : "0"));
        result = new PrivateApiResultAsJson(COMMAND, additionalPostParams);
    }

    @Override
    public String json() throws ApiException {
        return result.json();
    }
}
