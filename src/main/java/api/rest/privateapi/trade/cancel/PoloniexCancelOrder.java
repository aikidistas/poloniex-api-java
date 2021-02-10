package api.rest.privateapi.trade.cancel;

import api.rest.Json;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class PoloniexCancelOrder implements CancelOrder {

    private final Json jsonSource;

    public PoloniexCancelOrder(String orderNumber) {
        this(new PoloniexCancelOrderAsJson(orderNumber));
    }

    public PoloniexCancelOrder(Json jsonSource) {
        this.jsonSource = jsonSource;
    }

    @Override
    public boolean execute() throws Exception {
        try {
            return 1 == new Gson()
                    .fromJson(jsonSource.json(), JsonObject.class)
                    .get("success")
                    .getAsInt();
        } catch (Exception e) {
            final String message = "Error executing cancel order - {}";
            log.error(message, e.getMessage());
            throw new Exception(message, e);
        }
    }
}
