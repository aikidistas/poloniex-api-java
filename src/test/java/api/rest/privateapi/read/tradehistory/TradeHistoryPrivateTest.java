package api.rest.privateapi.read.tradehistory;

import lombok.SneakyThrows;
import org.junit.Test;

import static api.rest.ApiResultPrintHelper.printAndWait;

public class TradeHistoryPrivateTest {

    @SneakyThrows
    @Test
    public void tradeHistory() {
        printAndWait(
                new TradeHistoryPrivate("USDT_ETH").data()
        );
    }

    // TODO: fix json parse issue

    // TODO: continue documenting other usages
}