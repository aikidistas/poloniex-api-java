package api.rest.privateapi.read.openorders;


import api.rest.Json;
import api.rest.privateapi.read.openorders.dto.OpenOrderDto;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2
public final class OpenOrders implements OpenOrdersData {
    private final Json jsonSource;


    public OpenOrders(String currencyPair) {
        this(new OpenOrdersAsJson(currencyPair));
    }

    public OpenOrders() {
        this(new OpenOrdersAsJson());
    }

    public OpenOrders(Json jsonSource) {
        this.jsonSource = jsonSource;
    }

    @Override
    public List<OpenOrderDto> data() throws Exception {
        try {
            return new Gson().fromJson(
                    jsonSource.json(),
                    new TypeToken<List<OpenOrderDto>>() {
                    }.getType()
            );
        } catch (Exception e) {
            final String message = "Error retrieving data from Api - {}";
            log.error(message, e.getMessage());
            throw new Exception(message, e);
        }
    }
}
