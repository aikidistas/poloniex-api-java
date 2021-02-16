package api.wss.handler;

import api.wss.model.PoloniexWSSTickerDto;
import com.google.gson.Gson;
import lombok.extern.log4j.Log4j2;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;


@Log4j2
public final class TickerUsdtEthMessageHandler implements IMessageHandler {

    private final static Gson GSON = new Gson();

    public static PoloniexWSSTickerDto mapMessageToPoloniexTicker(String message) {
        List results = GSON.fromJson(message, List.class);
        if (results.size() < 3) {
            return null;
        }

        List olhc = (List) results.get(2);
        final int currencyPair = ((Double) olhc.get(0)).intValue();
        if (currencyPair != 149) {
            return null;
        }
        return PoloniexWSSTickerDto.builder()
                .currencyPair(currencyPair)
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

    @Override
    public void handle(String message) {
        PoloniexWSSTickerDto ticker = mapMessageToPoloniexTicker(message);
        if (Objects.nonNull(ticker)) {
//            log.info(ticker);
            System.out.println(ticker);
        }
    }

}
