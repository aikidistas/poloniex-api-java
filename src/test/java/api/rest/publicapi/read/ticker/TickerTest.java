package api.rest.publicapi.read.ticker;

import api.rest.publicapi.read.ticker.dto.TickerDto;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.concurrent.TimeUnit;

class TickerTest {

    @SneakyThrows
    @Test
    public void returnUsdtEthTicker() {
        TickerDto usdtEth = new Ticker.Smart(new Ticker()).data("USDT_ETH");
        System.out.println("USDT_ETH. \t\tBid: " + usdtEth.highestBid + ". \tAsk: " + usdtEth.lowestAsk);
        TimeUnit.SECONDS.sleep(1);
    }

    @SneakyThrows
    @Test
    public void returnTickers() {
        Map<String, TickerDto> tickerMap = new Ticker().data();
        for (Map.Entry<String, TickerDto> ticker : tickerMap.entrySet()) {
            System.out.println(ticker.getKey() + ". Bid: " + formatBigDecimal(ticker.getValue().highestBid) + ". Ask: " + formatBigDecimal(ticker.getValue().lowestAsk));
        }

        TimeUnit.SECONDS.sleep(1);
    }

    private String formatBigDecimal(BigDecimal number) {
        return number.setScale(8, RoundingMode.HALF_UP).toPlainString();
    }
}