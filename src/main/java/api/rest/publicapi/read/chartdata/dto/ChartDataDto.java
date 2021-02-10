package api.rest.publicapi.read.chartdata.dto;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@AllArgsConstructor
@ToString
public class ChartDataDto {

    public final ZonedDateTime date;
    public final BigDecimal high;
    public final BigDecimal low;
    public final BigDecimal open;
    public final BigDecimal close;
    public final BigDecimal volume;
    public final BigDecimal quoteVolume;
    public final BigDecimal weightedAverage;
}
