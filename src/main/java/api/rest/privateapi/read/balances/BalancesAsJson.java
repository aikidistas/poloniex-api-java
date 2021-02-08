package api.rest.privateapi.read.balances;

import api.rest.ApiException;
import api.rest.Json;
import api.rest.privateapi.PrivateApiResultAsJson;
import com.jcabi.aspects.RetryOnFailure;

class BalancesAsJson implements Json {
    private static final String COMMAND = "returnBalances";
    private final Json result;

    BalancesAsJson() {
        result = new PrivateApiResultAsJson(COMMAND);
    }

    @RetryOnFailure
    @Override
    public String json() throws ApiException {
        return result.json();
    }
}
