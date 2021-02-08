package api.rest.privateapi.read.openorders;

import api.rest.ApiException;
import api.rest.Json;
import api.rest.privateapi.PrivateApiResultAsJson;
import com.jcabi.aspects.RetryOnFailure;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

class OpenOrdersAsJson implements Json {
    private static final String COMMAND = "returnOpenOrders";
    private final Json result;

    OpenOrdersAsJson() {
        this("all");
    }

    OpenOrdersAsJson(String currencyPair) {
        List<NameValuePair> additionalPostParams = new ArrayList<>();
        additionalPostParams.add(new BasicNameValuePair("currencyPair", currencyPair));
        result = new PrivateApiResultAsJson(COMMAND, additionalPostParams);
    }

    @RetryOnFailure
    @Override
    public String json() throws ApiException {
        return result.json();
    }
}
