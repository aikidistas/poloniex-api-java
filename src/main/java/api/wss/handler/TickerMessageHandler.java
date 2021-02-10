package api.wss.handler;

import api.wss.model.PoloniexWSSTickerDto;
import com.google.gson.Gson;
import lombok.extern.log4j.Log4j2;

import java.math.BigDecimal;
import java.util.List;


@Log4j2
public class TickerMessageHandler implements IMessageHandler {

    private final static Gson GSON = new Gson();

    @Override
    public void handle(String message) {
        PoloniexWSSTickerDto ticker = this.mapMessageToPoloniexTicker(message);
        log.debug(ticker);

    }

    protected PoloniexWSSTickerDto mapMessageToPoloniexTicker(String message) {
        List results = GSON.fromJson(message, List.class);
        if (results.size() < 3) {
            return null;
        }

        List olhc = (List) results.get(2);
        return PoloniexWSSTickerDto.builder()
                .currencyPair((Double) olhc.get(0))
                .lastPrice(new BigDecimal((String) olhc.get(1)))
                .lowestAsk(new BigDecimal((String) olhc.get(2)))
                .highestBid(new BigDecimal((String) olhc.get(3)))
                .percentChange(new BigDecimal((String) olhc.get(4)))
                .baseVolume(new BigDecimal((String) olhc.get(5)))
                .quoteVolume(new BigDecimal((String) olhc.get(6)))
                .isFrozen(((double) olhc.get(7)) == 1)
                .twentyFourHourHigh(new BigDecimal((String) olhc.get(8)))
                .twentyFourHourLow(new BigDecimal((String) olhc.get(9)))
                .build();
    }

}
