package api.rest.privateapi.read.tradehistory;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import static api.rest.ApiResultPrintHelper.printAndWait;

public class TradeHistoryPrivateAsJsonTest {

    public static final ZonedDateTime START_ZONED_DATE_TIME = ZonedDateTime.of(2021, 01, 31, 0, 0, 0, 0, ZoneId.of("UTC"));
    public static final ZonedDateTime END_ZONED_DATE_TIME = ZonedDateTime.of(2021, 01, 31, 23, 59, 59, 0, ZoneId.of("UTC"));
    public static final long START_TIMESTAMP = START_ZONED_DATE_TIME.toEpochSecond();
    public static final long END_TIMESTAMP = END_ZONED_DATE_TIME.toEpochSecond();

//    @SneakyThrows
//    @Test
//    @Deprecated
//    public void privateTradeHistoryForAllCurrencyPairsToday() {
//        printAndWait(
//                new TradeHistoryPrivateAsJson().json()
//        );
//    }

//    @SneakyThrows
//    @Test
//    @Deprecated
//    public void privateTradeHistoryForAllCurrencyPairsBetweenSpecifiedTimestamps() {
//        printAndWait(
//                new TradeHistoryPrivateAsJson(START_TIMESTAMP, END_TIMESTAMP).json()
//        );
//    }

//    @SneakyThrows
//    @Test
//    @Deprecated
//    public void privateTradeHistoryForAllCurrencyPairsBetweenZonedDateTimes() {
//        printAndWait(
//                new TradeHistoryPrivateAsJson(START_ZONED_DATE_TIME, END_ZONED_DATE_TIME).json()
//        );
//    }

    @SneakyThrows
    @Test
    public void privateTradeHistoryForUsdtEthCurrencyPairToday() {
        printAndWait(
                new TradeHistoryPrivateAsJson("USDT_ETH").json()
        );
    }

    @SneakyThrows
    @Test
    public void privateTradeHistoryForUsdtEthCurrencyPairBetweenSpecifiedTimestamps() {
        printAndWait(
                new TradeHistoryPrivateAsJson("USDT_ETH", START_TIMESTAMP, END_TIMESTAMP).json()
        );
    }

    @SneakyThrows
    @Test
    public void privateTradeHistoryForUsdtEthCurrencyPairBetweenZonedDateTimes() {
        printAndWait(
                new TradeHistoryPrivateAsJson("USDT_ETH", START_ZONED_DATE_TIME, END_ZONED_DATE_TIME).json()
        );
    }
}