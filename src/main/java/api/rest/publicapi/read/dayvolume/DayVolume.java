package api.rest.publicapi.read.dayvolume;

import api.rest.ApiReadException;
import api.rest.Json;
import api.rest.publicapi.read.chartdata.dto.ChartDataDto;
import api.rest.publicapi.read.chartdata.dto.ChartDataDtoDeserializer;
import api.rest.publicapi.read.dayvolume.dto.DayVolumeDto;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.reflect.TypeToken;
import lombok.extern.log4j.Log4j2;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

@Log4j2
public class DayVolume implements DayVolumeData {
    private final static DateTimeFormatter DATE_TIME_FORMATTER =
            new DateTimeFormatterBuilder()
                    .appendPattern("yyyy-MM-dd HH:mm:ss")
                    .appendFraction(ChronoField.MICRO_OF_SECOND, 0, 6, true)
                    .toFormatter().withZone(ZoneOffset.UTC);

    private final Json jsonSource;


    public DayVolume() {
        this(new DayVolumeAsJson());
    }

    public DayVolume(Json jsonSource) {
        this.jsonSource = jsonSource;
    }

    @Override
    public DayVolumeDto data() throws ApiReadException {
        try {
            return new GsonBuilder()
                    .registerTypeAdapter(ZonedDateTime.class, (JsonDeserializer<ZonedDateTime>) (json, type, jsonDeserializationContext) -> ZonedDateTime.parse(json.getAsJsonPrimitive().getAsString(), DATE_TIME_FORMATTER)).registerTypeAdapter(ChartDataDto.class, new ChartDataDtoDeserializer())
                    .create().fromJson(jsonSource.json(), new TypeToken<DayVolumeDto>() {
                    }.getType());
        } catch (Exception e) {
            final String message = "Error retrieving 24hVolume - {}";
            log.error(message, e.getMessage());
            throw new ApiReadException(message, e);
        }
    }
}
