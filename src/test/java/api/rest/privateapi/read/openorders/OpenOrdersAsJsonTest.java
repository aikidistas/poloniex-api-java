package api.rest.privateapi.read.openorders;

import lombok.SneakyThrows;
import org.junit.Test;

import static api.rest.ApiResultPrintHelper.printAndWait;

public class OpenOrdersAsJsonTest {

    @SneakyThrows
    @Test
    public void currencyPairOpenOrders() {
        printAndWait(
                new OpenOrdersAsJson("USDT_ETH").json()
        );
    }

    @SneakyThrows
    @Test
    public void allCurrencyPairsOpenOrders() {
        printAndWait(
                new OpenOrdersAsJson().json()
        );
    }
}