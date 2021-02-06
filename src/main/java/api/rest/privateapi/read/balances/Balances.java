package api.rest.privateapi.read.balances;

import api.rest.ApiReadException;
import api.rest.Json;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.log4j.Log4j2;

import java.math.BigDecimal;
import java.util.Map;

@Log4j2
public class Balances implements BalancesData {
    private final Json jsonSource;


    public Balances() {
        this(new BalancesAsJson());
    }

    public Balances(Json jsonSource) {
        this.jsonSource = jsonSource;
    }

    @Override
    public Map<String, BigDecimal> data() throws ApiReadException {
        try {
            return new Gson().fromJson(
                    jsonSource.json(),
                    new TypeToken<Map<String, BigDecimal>>() {
                    }.getType()
            );
        } catch (Exception ex) {
            log.error("Error retrieving data from Api - {}", ex.getMessage());
            throw new ApiReadException(ex);
        }
    }
}
