package api.rest.privateapi.trade.trade;

import api.rest.Json;
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
import java.util.Objects;

@Log4j2
public class PoloniexTradeOrder implements TradeOrder {
    private static final DateTimeFormatter DATE_TIME_FORMATTER =
            new DateTimeFormatterBuilder()
                    .appendPattern("yyyy-MM-dd HH:mm:ss")
                    .appendFraction(ChronoField.MICRO_OF_SECOND, 0, 6, true)
                    .toFormatter().withZone(ZoneOffset.UTC);

    private final Json jsonSource;

    public PoloniexTradeOrder(TradeCommand command, String currencyPair, BigDecimal price, BigDecimal amount) {
        this(new PoloniexTradeOrderResultAsJson(command.toString(), currencyPair, price, amount));
    }

    public PoloniexTradeOrder(TradeCommand command, String currencyPair, BigDecimal price, BigDecimal amount, boolean fillOrKill, boolean immediateOrCancel, boolean postOnly) {
        this(new PoloniexTradeOrderResultAsJson(command.toString(), currencyPair, price, amount, fillOrKill, immediateOrCancel, postOnly));
    }

    public PoloniexTradeOrder(Json jsonSource) {
        this.jsonSource = jsonSource;
    }

    @Override
    public OrderResultDto execute() throws Exception {
        OrderResultDto result = orderResult();

        if (Objects.nonNull(result.error)) {
            throw new Exception("Failed to execute trade order. Error received from api: " + result.error);
        }

        return result;
    }

    private OrderResultDto orderResult() throws Exception {
        try {
            return new GsonBuilder()
                    .registerTypeAdapter(ZonedDateTime.class, (JsonDeserializer<ZonedDateTime>) (json, type, jsonDeserializationContext) -> ZonedDateTime.parse(json.getAsJsonPrimitive().getAsString(), DATE_TIME_FORMATTER))
                    .create().fromJson(
                            jsonSource.json(),
                            new TypeToken<OrderResultDto>() {
                            }.getType()
                    );
        } catch (Exception e) {
            final String message = "Error executing trade Api - {}";
            log.error(message, e.getMessage());
            throw new Exception(message, e);
        }
    }
}
