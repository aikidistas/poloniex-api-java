package api.rest.privateapi.read.ordertrades;

import api.rest.ApiException;
import api.rest.Json;
import api.rest.privateapi.PrivateApiResultAsJson;
import com.jcabi.aspects.RetryOnFailure;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

class OrderTradesAsJson implements Json {
    private static final String COMMAND = "returnOrderTrades";
    private final Json result;

    OrderTradesAsJson(String orderNumber) {
        List<NameValuePair> additionalPostParams = new ArrayList<>();
        additionalPostParams.add(new BasicNameValuePair("orderNumber", orderNumber));
        result = new PrivateApiResultAsJson(COMMAND, additionalPostParams);
    }

    @RetryOnFailure
    @Override
    public String json() throws ApiException {
        return result.json();
    }
}
