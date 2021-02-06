package api.rest.privateapi.trade.move;

import api.rest.ApiException;
import api.rest.Json;
import api.rest.privateapi.PrivateApiResultAsJson;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

class MoveAsJson implements Json {
    private static final String COMMAND = "moveOrder";
    private final Json result;

    MoveAsJson(String orderNumber, BigDecimal rate) {
        List<NameValuePair> additionalPostParams = new ArrayList<>();
        additionalPostParams.add(new BasicNameValuePair("orderNumber", orderNumber));
        additionalPostParams.add(new BasicNameValuePair("rate", rate.toPlainString()));
        additionalPostParams.add(new BasicNameValuePair("postOnly", "0"));
        additionalPostParams.add(new BasicNameValuePair("immediateOrCancel", "0"));
        result = new PrivateApiResultAsJson(COMMAND, additionalPostParams);
    }

    @Override
    public String json() throws ApiException {
        return result.json();
    }
}
