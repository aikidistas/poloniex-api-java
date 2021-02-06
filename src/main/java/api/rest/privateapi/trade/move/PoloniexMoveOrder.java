package api.rest.privateapi.trade.move;

import api.rest.Json;
import api.rest.privateapi.trade.ApiOrderException;
import api.rest.privateapi.trade.dto.OrderResultDto;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.reflect.TypeToken;
import lombok.extern.log4j.Log4j2;

import java.math.BigDecimal;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

@Log4j2
public class PoloniexMoveOrder implements MoveOrder {

    private final static DateTimeFormatter DATE_TIME_FORMATTER =
            new DateTimeFormatterBuilder()
                    .appendPattern("yyyy-MM-dd HH:mm:ss")
                    .appendFraction(ChronoField.MICRO_OF_SECOND, 0, 6, true)
                    .toFormatter().withZone(ZoneOffset.UTC);

    private final Json jsonSource;

    public PoloniexMoveOrder(String orderNumber, BigDecimal rate) {
        this(new PoloniexMoveOrderAsJson(orderNumber, rate));
    }

    public PoloniexMoveOrder(Json jsonSource) {
        this.jsonSource = jsonSource;
    }

    @Override
    public OrderResultDto execute() throws ApiOrderException {
        try {
            return new GsonBuilder()
                    .registerTypeAdapter(ZonedDateTime.class, (JsonDeserializer<ZonedDateTime>) (json, type, jsonDeserializationContext) -> ZonedDateTime.parse(json.getAsJsonPrimitive().getAsString(), DATE_TIME_FORMATTER))
                    .create()
                    .fromJson(
                            jsonSource.json(),
                            new TypeToken<OrderResultDto>() {
                            }.getType()
                    );
        } catch (Exception ex) {
            log.error("Error executing trade Api - {}", ex.getMessage());
            throw new ApiOrderException(ex);
        }
    }
}
