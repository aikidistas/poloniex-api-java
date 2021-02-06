package api.rest.privateapi.read.balances;

import lombok.SneakyThrows;
import org.junit.Test;

import static api.rest.ApiResultPrintHelper.printAndWait;

public class BalancesTest {

    @SneakyThrows
    @Test
    public void balances() {
        printAndWait(
                new Balances().data()
        );
    }

    @SneakyThrows
    @Test
    public void positiveBalances() {
        printAndWait(
                new BalancesData.Smart(new Balances()).positiveBalances()
        );
    }

    @SneakyThrows
    @Test
    public void usdtBalances() {
        printAndWait(
                new BalancesData.Smart(new Balances()).usdt()
        );
    }

    @SneakyThrows
    @Test
    public void ethBalances() {
        printAndWait(
                new BalancesData.Smart(new Balances()).eth()
        );
    }
}