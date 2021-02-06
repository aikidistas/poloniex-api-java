package api.rest.privateapi.trade.cancel;

import api.rest.Json;
import api.rest.privateapi.trade.ApiOrderException;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class CancelOrderOrderImpl implements CancelOrder {

    private final Json jsonSource;

    public CancelOrderOrderImpl(String orderNumber) {
        this(new CancelAsJson(orderNumber));
    }

    public CancelOrderOrderImpl(Json jsonSource) {
        this.jsonSource = jsonSource;
    }

    @Override
    public Boolean execute() throws ApiOrderException {
        try {
            return 1 == new Gson()
                    .fromJson(jsonSource.json(), JsonObject.class)
                    .get("success")
                    .getAsInt();
        } catch (Exception ex) {
            log.error("Error executing cancel order - {}", ex.getMessage());
            throw new ApiOrderException(ex);
        }
    }
}
