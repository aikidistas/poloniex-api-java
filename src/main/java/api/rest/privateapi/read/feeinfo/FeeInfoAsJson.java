package api.rest.privateapi.read.feeinfo;

import api.rest.Json;
import api.rest.privateapi.PrivateApiResultAsJson;

class FeeInfoAsJson implements Json {
    private static final String COMMAND = "returnFeeInfo";
    private final Json result;

    FeeInfoAsJson() {
        result = new PrivateApiResultAsJson(COMMAND);
    }

    @Override
    public String json() throws Exception {
        return result.json();
    }
}
