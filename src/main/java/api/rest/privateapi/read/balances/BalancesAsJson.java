package api.rest.privateapi.read.balances;


import api.rest.Json;
import api.rest.privateapi.PrivateApiResultAsJson;

class BalancesAsJson implements Json {
    private static final String COMMAND = "returnBalances";
    private final Json result;

    BalancesAsJson() {
        result = new PrivateApiResultAsJson(COMMAND);
    }

    @Override
    public String json() throws Exception {
        return result.json();
    }
}
