package api.rest.publicapi.read.currencies;

import api.rest.ApiException;
import api.rest.Json;
import api.rest.publicapi.PublicApiCommandResultAsJson;

class CurrenciesAsJson implements Json {
    private static final String COMMAND = "command=returnCurrencies";
    private final Json result;

    CurrenciesAsJson() {
        result = new PublicApiCommandResultAsJson(COMMAND);
    }


    CurrenciesAsJson(Json json) {
        result = json;
    }

    @Override
    public String json() throws ApiException {
        return result.json();
    }
}
