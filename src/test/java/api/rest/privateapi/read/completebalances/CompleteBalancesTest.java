package api.rest.privateapi.read.completebalances;

import lombok.SneakyThrows;
import org.junit.Test;

import static api.rest.ApiResultPrintHelper.printAndWait;

public class CompleteBalancesTest {

    @SneakyThrows
    @Test
    public void completeBalancesForAllCurrencies() {
        printAndWait(
                new CompleteBalances().data()
        );
    }

    @SneakyThrows
    @Test
    public void completeBalancesForOneCurrency() {
        printAndWait(
                new CompleteBalancesData.Smart(new CompleteBalances()).data("USDT").toString()
        );
    }

    @SneakyThrows
    @Test
    public void completeBalancesForUsdt() {
        printAndWait(
                new CompleteBalancesData.Smart(new CompleteBalances()).usdt().toString()
        );
    }

    @SneakyThrows
    @Test
    public void completeBalancesForEth() {
        printAndWait(
                new CompleteBalancesData.Smart(new CompleteBalances()).eth().toString()
        );
    }

    @SneakyThrows
    @Test
    public void completeBalancesPositiveOnly() {
        printAndWait(
                new CompleteBalancesData.Smart(new CompleteBalances()).positiveBalances().toString()
        );
    }


}