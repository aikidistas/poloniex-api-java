package api.rest.privateapi.trade.trade;


import api.rest.Json;
import api.rest.privateapi.PrivateApiResultAsJson;
import lombok.SneakyThrows;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.cactoos.Scalar;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PoloniexTradeOrderResultAsJson implements Json {
    private final Json result;

    public PoloniexTradeOrderResultAsJson(String command, String currencyPair, BigDecimal rate, BigDecimal amount) {
        this(command, currencyPair, () -> rate, () -> amount);
    }

    public PoloniexTradeOrderResultAsJson(String command, String currencyPair, Scalar<BigDecimal> rate, Scalar<BigDecimal> amount) {
        this(command, currencyPair, rate, amount, false, false, false);
    }

    public PoloniexTradeOrderResultAsJson(String command, String currencyPair, BigDecimal rate, BigDecimal amount, boolean fillOrKill, boolean immediateOrCancel, boolean postOnly) {
        this(command, currencyPair, () -> rate, () -> amount, fillOrKill, immediateOrCancel, postOnly);
    }

    // TODO: think how to postpone  exception till json() is called
    @SneakyThrows
    public PoloniexTradeOrderResultAsJson(String command, String currencyPair, Scalar<BigDecimal> rate, Scalar<BigDecimal> amount, boolean fillOrKill, boolean immediateOrCancel, boolean postOnly) {
        List<NameValuePair> additionalPostParams = new ArrayList<>();
        additionalPostParams.add(new BasicNameValuePair("currencyPair", currencyPair));
        additionalPostParams.add(new BasicNameValuePair("rate", rate.value().toPlainString()));
        additionalPostParams.add(new BasicNameValuePair("amount", amount.value().toPlainString()));
        additionalPostParams.add(new BasicNameValuePair("fillOrKill", fillOrKill ? "1" : "0"));
        additionalPostParams.add(new BasicNameValuePair("immediateOrCancel", immediateOrCancel ? "1" : "0"));
        additionalPostParams.add(new BasicNameValuePair("postOnly", postOnly ? "1" : "0"));
        result = new PrivateApiResultAsJson(command, additionalPostParams);
    }

    @Override
    public String json() throws Exception {
        return result.json();
    }
}
