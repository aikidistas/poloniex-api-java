package api.mano;

import api.rest.publicapi.read.chartdata.ChartData;
import api.rest.publicapi.read.chartdata.dto.ChartDataDto;
import api.rest.publicapi.read.chartdata.enums.ChartDataPeriod;
import api.rest.publicapi.read.dayvolume.DayVolume;
import api.rest.publicapi.read.dayvolume.dto.DayVolumeDto;
import api.rest.publicapi.read.ticker.Ticker;
import api.rest.publicapi.read.ticker.TickerData;
import api.rest.publicapi.read.ticker.dto.TickerDto;
import lombok.SneakyThrows;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class PoloniexPublicObjectApiManoTest {


    @Before
    public void setUp() {
    }

    @SneakyThrows
    @Test
    public void returnUsdtEthTicker() {
        TickerDto usdtEth = new TickerData.Smart(new Ticker()).data("USDT_ETH");
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

    @SneakyThrows
    @Test
    public void return24hVolume() {
        DayVolumeDto result = new DayVolume().data();
        System.out.println(result.toString());
        TimeUnit.SECONDS.sleep(1);
    }

    @Test
    @Ignore
    public void _returnOrderBook() {
        assert (false);
    }

    @Test
    @Ignore
    public void _returnTradeHistory() {
        assert (false);
        //        TODO: currencly this is calling private TradeHistoryPrivate api. public TradeHistoryPrivate is not created
        //        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("UTC"));
        //        ZonedDateTime lastHour = now.minusHours(1L);
        //        List<TradeHistoryDto> tradeHistories = publicApi.returnTradeHistory("USDT_ETH", lastHour.toEpochSecond(), now.toEpochSecond());
        //        tradeHistories.forEach(th -> System.out.println(th.toString()));
        //        TimeUnit.SECONDS.sleep(1);
    }

    @Test
    @Ignore
    public void _returnCurrencies() {
        assert (false);
    }

    @SneakyThrows
    @Test
    public void returnChartData() {
        List<ChartDataDto> chartDataList = new ChartData("USDT_ETH", ChartDataPeriod.HOURS_24, ZonedDateTime.of(2020, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC).toEpochSecond(), ZonedDateTime.of(2020, 1, 5, 0, 0, 0, 0, ZoneOffset.UTC).toEpochSecond()).chartData();

        chartDataList.forEach((ChartDataDto chart) -> System.out.println(chart.toString()));
        TimeUnit.SECONDS.sleep(1);
    }


    private String formatBigDecimal(BigDecimal number) {
        return number.setScale(8, RoundingMode.HALF_UP).toPlainString();
    }

}