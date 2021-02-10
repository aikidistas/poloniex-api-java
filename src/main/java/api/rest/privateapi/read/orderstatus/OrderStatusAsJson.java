package api.rest.privateapi.read.orderstatus;


import api.rest.Json;
import api.rest.privateapi.PrivateApiResultAsJson;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

class OrderStatusAsJson implements Json {
    private static final String COMMAND = "returnOrderStatus";
    private final Json result;

    OrderStatusAsJson(String orderNumber) {
        List<NameValuePair> additionalPostParams = new ArrayList<>();
        additionalPostParams.add(new BasicNameValuePair("orderNumber", orderNumber));
        result = new PrivateApiResultAsJson(COMMAND, additionalPostParams);
    }

    @Override
    public String json() throws Exception {
        return result.json();
    }
}
