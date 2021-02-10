package api.rest.publicapi.read.ticker;


import api.rest.Json;
import api.rest.publicapi.PublicApiCommandResultAsJson;

class TickerAsJson implements Json {
    private static final String COMMAND = "command=returnTicker";
    private final Json result;

    TickerAsJson() {
        this(new PublicApiCommandResultAsJson(COMMAND));
    }


    TickerAsJson(Json json) {
        result = json;
    }

    @Override
    public String json() throws Exception {
        return result.json();
    }
}
