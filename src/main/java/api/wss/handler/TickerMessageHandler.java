package api.wss.handler;

import api.wss.model.PoloniexWSSTicker;
import com.google.gson.Gson;
import lombok.extern.log4j.Log4j2;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author David
 */
@Log4j2
public class TickerMessageHandler implements IMessageHandler {

    private final static Gson GSON = new Gson();

    @Override
    public void handle(String message) {
        PoloniexWSSTicker ticker = this.mapMessageToPoloniexTicker(message);
        log.debug(ticker);

    }

    protected PoloniexWSSTicker mapMessageToPoloniexTicker(String message) {
        List results = GSON.fromJson(message, List.class);
        if (results.size() < 3) {
            return null;
        }

        List olhc = (List) results.get(2);
        return new PoloniexWSSTicker.PoloniexWSSTickerBuilder()
                .setCurrencyPair((Double) olhc.get(0))
                .setLastPrice(new BigDecimal((String) olhc.get(1)))
                .setLowestAsk(new BigDecimal((String) olhc.get(2)))
                .setHighestBid(new BigDecimal((String) olhc.get(3)))
                .setPercentChange(new BigDecimal((String) olhc.get(4)))
                .setBaseVolume(new BigDecimal((String) olhc.get(5)))
                .setQuoteVolume(new BigDecimal((String) olhc.get(6)))
                .setIsFrozen(((double) olhc.get(7)) == 1)
                .setTwentyFourHourHigh(new BigDecimal((String) olhc.get(8)))
                .setTwentyFourHourLow(new BigDecimal((String) olhc.get(9)))
                .buildPoloniexTicker();
    }

}
