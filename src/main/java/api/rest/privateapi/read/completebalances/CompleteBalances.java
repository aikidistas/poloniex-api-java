package api.rest.privateapi.read.completebalances;

import api.rest.ApiReadException;
import api.rest.Json;
import api.rest.privateapi.read.completebalances.dto.CompleteBalanceDto;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.log4j.Log4j2;
import org.cactoos.scalar.Retry;

import java.util.Map;

@Log4j2
public class CompleteBalances implements CompleteBalancesData {
    public static final int RETRY_ATTEMPTS = 5;
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
            return new Retry<Map<String, CompleteBalanceDto>>(
                    () -> new Gson().fromJson(
                            jsonSource.json(),
                            new TypeToken<Map<String, CompleteBalanceDto>>() {
                            }.getType()
                    ),
                    RETRY_ATTEMPTS
            ).value();
        } catch (Exception e) {
            log.error("Can't read complete balances after multiple retries", e);
            throw new ApiReadException("Can't read complete balances after multiple retries", e);
        }
    }
}
