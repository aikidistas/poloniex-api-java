package api.rest.publicapi.read.ticker.dto;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

/**
 * @author David
 */
@AllArgsConstructor
public class TickerDto {
    public final BigDecimal last;
    public final BigDecimal lowestAsk;
    public final BigDecimal highestBid;
    public final BigDecimal percentChange;
    public final BigDecimal baseVolume;
    public final BigDecimal quoteVolume;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
