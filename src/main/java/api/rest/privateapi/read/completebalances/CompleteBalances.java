package api.rest.privateapi.read.completebalances;

import api.rest.ApiReadException;
import api.rest.Json;
import api.rest.privateapi.read.completebalances.dto.CompleteBalanceDto;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.log4j.Log4j2;

import java.util.Map;

@Log4j2
public class CompleteBalances implements CompleteBalancesData {
    private final Json jsonSource;


    public CompleteBalances() {
        this(new CompleteBalancesAsJson());
    }

    public CompleteBalances(Json jsonSource) {
        this.jsonSource = jsonSource;
    }

    @Override
    public Map<String, CompleteBalanceDto> data() throws ApiReadException {
        try {
            return new Gson().fromJson(
                    jsonSource.json(),
                    new TypeToken<Map<String, CompleteBalanceDto>>() {
                    }.getType()
            );
        } catch (Exception ex) {
            log.error("Error retrieving data from Api - {}", ex.getMessage());
            throw new ApiReadException(ex);
        }
    }
}
