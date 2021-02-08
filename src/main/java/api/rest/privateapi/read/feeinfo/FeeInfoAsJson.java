package api.rest.privateapi.read.feeinfo;

import api.rest.ApiException;
import api.rest.Json;
import api.rest.privateapi.PrivateApiResultAsJson;
import com.jcabi.aspects.RetryOnFailure;

class FeeInfoAsJson implements Json {
    private static final String COMMAND = "returnFeeInfo";
    private final Json result;

    FeeInfoAsJson() {
        result = new PrivateApiResultAsJson(COMMAND);
    }

    @RetryOnFailure
    @Override
    public String json() throws ApiException {
        return result.json();
    }
}
