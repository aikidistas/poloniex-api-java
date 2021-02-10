package api.rest.privateapi.read.completebalances;


import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static api.rest.ApiResultPrintHelper.printAndWait;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CompleteBalancesTest {


    @SneakyThrows
    @Test
    public void mapCompleteBalanceResultForCurrencyReturnsCorrectBalanceResult() {
        String currencyType = "BTC";
        String completeBalanceResults = "{\n"
                + "	\"YACC\" : {\n"
                + "		\"available\" : \"0.00000000\",\n"
                + "		\"onOrders\" : \"0.00000000\",\n"
                + "		\"btcValue\" : \"0.00000000\"\n"
                + "	},\n"
                + "	\"YANG\" : {\n"
                + "		\"available\" : \"0.00000000\",\n"
                + "		\"onOrders\" : \"0.00000000\",\n"
                + "		\"btcValue\" : \"0.00000000\"\n"
                + "	},\n"
                + "	\"YC\" : {\n"
                + "		\"available\" : \"0.00000000\",\n"
                + "		\"onOrders\" : \"0.00000000\",\n"
                + "		\"btcValue\" : \"0.00000000\"\n"
                + "	},\n"
                + "	\"BTC\" : {\n"
                + "		\"available\" : \"5.00000000\",\n"
                + "		\"onOrders\" : \"1.00000000\",\n"
                + "		\"btcValue\" : \"2.00000000\"\n"
                + "	}\n"
                + "}";
        assertNotNull(new CompleteBalances.Smart(new CompleteBalances(() -> completeBalanceResults)).data(currencyType));
    }

    @Test
    public void mapCompleteBalanceResultReturnsNullForInvalidCurrencyType() {
        String currencyType = "BTC";
        String completeBalanceResults = "{\n"
                + "	\"YACC\" : {\n"
                + "		\"available\" : \"0.00000000\",\n"
                + "		\"onOrders\" : \"0.00000000\",\n"
                + "		\"btcValue\" : \"0.00000000\"\n"
                + "	},\n"
                + "	\"YANG\" : {\n"
                + "		\"available\" : \"0.00000000\",\n"
                + "		\"onOrders\" : \"0.00000000\",\n"
                + "		\"btcValue\" : \"0.00000000\"\n"
                + "	},\n"
                + "	\"YC\" : {\n"
                + "		\"available\" : \"0.00000000\",\n"
                + "		\"onOrders\" : \"0.00000000\",\n"
                + "		\"btcValue\" : \"0.00000000\"\n"
                + "	},\n"
                + "	\"YIN\" : {\n"
                + "		\"available\" : \"0.00000000\",\n"
                + "		\"onOrders\" : \"0.00000000\",\n"
                + "		\"btcValue\" : \"0.00000000\"\n"
                + "	}\n"
                + "}";
        final CompleteBalances.Smart completeBalances = new CompleteBalances.Smart(new CompleteBalances(() -> completeBalanceResults));
        Assertions.assertThrows(Exception.class, () -> completeBalances.data(currencyType));
    }

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
                new CompleteBalancesData.Smart(new CompleteBalances()).data("USDT")
        );
    }

    @SneakyThrows
    @Test
    public void completeBalancesForUsdt() {
        printAndWait(
                new CompleteBalances.Smart(new CompleteBalances()).usdt()
        );
    }

    @SneakyThrows
    @Test
    public void completeBalancesForEth() {
        printAndWait(
                new CompleteBalances.Smart(new CompleteBalances()).eth()
        );
    }

    @SneakyThrows
    @Test
    public void completeBalancesPositiveOnly() {
        printAndWait(
                new CompleteBalances.Smart(new CompleteBalances()).positiveBalances()
        );
    }
}