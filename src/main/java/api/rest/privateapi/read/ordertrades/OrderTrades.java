package api.rest.privateapi.read.ordertrades;

import api.rest.ApiReadException;
import api.rest.Json;
import api.rest.privateapi.read.ordertrades.dto.OrderTradeDto;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.reflect.TypeToken;
import lombok.extern.log4j.Log4j2;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.List;

@Log4j2
public class OrderTrades implements OrderTradesData {
    private final static DateTimeFormatter DATE_TIME_FORMATTER =
            new DateTimeFormatterBuilder()
                    .appendPattern("yyyy-MM-dd HH:mm:ss")
                    .appendFraction(ChronoField.MICRO_OF_SECOND, 0, 6, true)
                    .toFormatter().withZone(ZoneOffset.UTC);

    private final Json jsonSource;

    public OrderTrades(String orderNumber) {
        this(new OrderTradesAsJson(orderNumber));
    }

    public OrderTrades(Json jsonSource) {
        this.jsonSource = jsonSource;
    }

    @Override
    public List<OrderTradeDto> data() throws ApiReadException {
        try {
            return new GsonBuilder()
                    .registerTypeAdapter(ZonedDateTime.class, (JsonDeserializer<ZonedDateTime>) (json, type, jsonDeserializationContext) -> ZonedDateTime.parse(json.getAsJsonPrimitive().getAsString(), DATE_TIME_FORMATTER))
                    .create()
                    .fromJson(
                            jsonSource.json(),
                            new TypeToken<List<OrderTradeDto>>() {
                            }.getType()
                    );
        } catch (Exception e) {
            final String message = "Error retrieving data from Api - {}";
            log.error(message, e.getMessage());
            throw new ApiReadException(message, e);
        }
    }
}
