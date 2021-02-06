package api.rest.privateapi.trade.cancel;

import api.rest.ApiException;
import api.rest.Json;
import api.rest.privateapi.PrivateApiResultAsJson;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

class PoloniexCancelOrderAsJson implements Json {
    private static final String COMMAND = "cancelOrder";
    private final Json result;

    PoloniexCancelOrderAsJson(String orderNumber) {
        List<NameValuePair> additionalPostParams = new ArrayList<>();
        additionalPostParams.add(new BasicNameValuePair("orderNumber", orderNumber));
        result = new PrivateApiResultAsJson(COMMAND, additionalPostParams);
    }

    @Override
    public String json() throws ApiException {
        return result.json();
    }
}
