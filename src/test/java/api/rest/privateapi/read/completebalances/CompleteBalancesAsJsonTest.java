package api.rest.privateapi.read.completebalances;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import static api.rest.ApiResultPrintHelper.printAndWait;

public class CompleteBalancesAsJsonTest {
    @SneakyThrows
    @Test
    public void json() {
        printAndWait(
                new CompleteBalancesAsJson().json()
        );
    }
}