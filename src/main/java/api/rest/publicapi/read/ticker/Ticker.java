package api.rest.publicapi.read.ticker;


import api.rest.Json;
import api.rest.publicapi.read.ticker.dto.TickerDto;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.log4j.Log4j2;

import java.util.Map;

@Log4j2
public class Ticker implements TickerData {
    private final Json jsonSource;


    public Ticker() {
        this(new TickerAsJson());
    }

    public Ticker(Json jsonSource) {
        this.jsonSource = jsonSource;
    }

    @Override
    public Map<String, TickerDto> data() throws Exception {
        try {
            return new Gson().fromJson(jsonSource.json(), new TypeToken<Map<String, TickerDto>>() {
            }.getType());
        } catch (Exception e) {
            final String message = "Error retrieving ticker - {}";
            log.error(message, e.getMessage());
            throw new Exception(message, e);
        }
    }
}
