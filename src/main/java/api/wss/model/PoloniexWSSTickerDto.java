package api.wss.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;

import java.math.BigDecimal;

@AllArgsConstructor
@ToString
@Builder
public class PoloniexWSSTickerDto {

//    public final Double currencyPair;
public final int currencyPair;
    public final BigDecimal lastPrice;
    public final BigDecimal lowestAsk;
    public final BigDecimal highestBid;
    public final BigDecimal percentChange;
    public final BigDecimal baseVolume;
    public final BigDecimal quoteVolume;
    public final boolean isFrozen;
    public final BigDecimal twentyFourHourHigh;
    public final BigDecimal twentyFourHourLow;
}
