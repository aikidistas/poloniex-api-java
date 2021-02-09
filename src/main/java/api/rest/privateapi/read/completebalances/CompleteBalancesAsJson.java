package api.rest.privateapi.read.completebalances;

import api.rest.ApiException;
import api.rest.Json;
import api.rest.privateapi.PrivateApiResultAsJson;

class CompleteBalancesAsJson implements Json {
    private static final String COMMAND = "returnCompleteBalances";
    private final Json result;

    CompleteBalancesAsJson() {
        result = new PrivateApiResultAsJson(COMMAND);
    }

    @Override
    public String json() throws ApiException {
        return result.json();
    }
}
