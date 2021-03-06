package api.rest.privateapi.read.balances;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import static api.rest.ApiResultPrintHelper.printAndWait;

public class BalancesAsJsonTest {

    @SneakyThrows
    @Test
    public void json() {
        printAndWait(
                new BalancesAsJson().json()
        );
    }
}