package api.rest.publicapi.read.chartdata;

import api.rest.ApiReadException;
import api.rest.Json;
import api.rest.publicapi.read.chartdata.dto.ChartDataDto;
import api.rest.publicapi.read.chartdata.dto.ChartDataDtoDeserializer;
import api.rest.publicapi.read.chartdata.enums.ChartDataPeriod;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSyntaxException;
import lombok.extern.log4j.Log4j2;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoField;
import java.util.Arrays;
import java.util.List;

@Log4j2
public class ChartData implements ChartDataResult {
    private final static String INVALID_CHART_DATA_DATE_RANGE_RESULT = "[{\"date\":0,\"high\":0,\"low\":0,\"open\":0,\"close\":0,\"volume\":0,\"quoteVolume\":0,\"weightedAverage\":0}]";
    private final static String INVALID_CHART_DATA_CURRENCY_PAIR_RESULT = "{\"error\":\"Invalid currency pair.\"}";
    private final static DateTimeFormatter DATE_TIME_FORMATTER =
            new DateTimeFormatterBuilder()
                    .appendPattern("yyyy-MM-dd HH:mm:ss")
                    .appendFraction(ChronoField.MICRO_OF_SECOND, 0, 6, true)
                    .toFormatter().withZone(ZoneOffset.UTC);

    private final Json chartDataJson;


    public ChartData(String currencyPair) {
        this(currencyPair, ChartDataPeriod.MINUTES_5, ZonedDateTime.now().minusDays(1), ZonedDateTime.now());
    }


    public ChartData(String currencyPair, ChartDataPeriod period, ZonedDateTime startTimestamp, ZonedDateTime endTimestamp) {
        this(currencyPair, period, startTimestamp.toEpochSecond(), endTimestamp.toEpochSecond());
    }

    public ChartData(String currencyPair, ChartDataPeriod period, long startTimestamp, long endTimestamp) {
        this(new ChartDataAsJson(currencyPair, period, startTimestamp, endTimestamp));
    }

    public ChartData(Json chartDataJson) {
        this.chartDataJson = chartDataJson;
    }

    @Override
    public List<ChartDataDto> chartData() throws ApiReadException {
        try {
            String chartDataResult = chartDataJson.json();

            if (INVALID_CHART_DATA_DATE_RANGE_RESULT.equals(chartDataResult)) {
                throw new ApiReadException("Can't read chart data. Invalid date range");
            }
            if (INVALID_CHART_DATA_CURRENCY_PAIR_RESULT.equals(chartDataResult)) {
                throw new ApiReadException("Can't read chart data. Invalid currency pair");
            }

            try {
                ChartDataDto[] chartDataResults = new GsonBuilder()
                        .registerTypeAdapter(
                                ZonedDateTime.class,
                                (JsonDeserializer<ZonedDateTime>) (json, type, jsonDeserializationContext) -> ZonedDateTime.parse(json.getAsJsonPrimitive().getAsString(), DATE_TIME_FORMATTER))
                        .registerTypeAdapter(ChartDataDto.class, new ChartDataDtoDeserializer())
                        .create().fromJson(chartDataResult, ChartDataDto[].class);
                return Arrays.asList(chartDataResults);
            } catch (JsonSyntaxException | DateTimeParseException e) {
                final String message = "Exception mapping chart data {} - {}";
                log.error(message, chartDataResult, e.getMessage());
                throw new ApiReadException(message, e);
            }

        } catch (Exception e) {
            final String message = "Error retrieving chartData - {}";
            log.error(message, e.getMessage());
            throw new ApiReadException(message, e);
        }
    }
}
