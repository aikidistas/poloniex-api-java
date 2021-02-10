package api.rest.privateapi.read.tradehistory;


import api.rest.Json;
import api.rest.privateapi.read.tradehistory.dto.TradeHistoryDto;
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
public class TradeHistoryPrivate implements TradeHistoryPrivateData {
    private final static DateTimeFormatter DATE_TIME_FORMATTER =
            new DateTimeFormatterBuilder()
                    .appendPattern("yyyy-MM-dd HH:mm:ss")
                    .appendFraction(ChronoField.MICRO_OF_SECOND, 0, 6, true)
                    .toFormatter().withZone(ZoneOffset.UTC);

    private final Json jsonSource;

//    public TradeHistoryPrivate() {
//        this(new TradeHistoryPrivateAsJson());
//    }

//    public TradeHistoryPrivate(ZonedDateTime start, ZonedDateTime end) {
//        this(new TradeHistoryPrivateAsJson(start, end));
//    }

//    public TradeHistoryPrivate(long start, long end) {
//        this(new TradeHistoryPrivateAsJson(start, end));
//    }

    public TradeHistoryPrivate(String currencyPair) {
        this(new TradeHistoryPrivateAsJson(currencyPair));
    }

    public TradeHistoryPrivate(String currencyPair, ZonedDateTime start, ZonedDateTime end) {
        this(new TradeHistoryPrivateAsJson(currencyPair, start, end));
    }

    public TradeHistoryPrivate(String currencyPair, long start, long end) {
        this(new TradeHistoryPrivateAsJson(currencyPair, start, end));
    }

    public TradeHistoryPrivate(Json jsonSource) {
        this.jsonSource = jsonSource;
    }

    @Override
    public List<TradeHistoryDto> data() throws Exception {
        try {
            return new GsonBuilder()
                    .registerTypeAdapter(ZonedDateTime.class, (JsonDeserializer<ZonedDateTime>) (json, type, jsonDeserializationContext) -> ZonedDateTime.parse(json.getAsJsonPrimitive().getAsString(), DATE_TIME_FORMATTER))
                    .create()
                    .fromJson(
                            jsonSource.json(),
                            new TypeToken<List<TradeHistoryDto>>() {
                            }.getType()
                    );
        } catch (Exception e) {
            final String message = "Error retrieving data from Api - {}";
            log.error(message, e.getMessage());
            throw new Exception(message, e);
        }
    }
}
