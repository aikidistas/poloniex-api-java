package api.rest.privateapi.read.feeinfo;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import static api.rest.ApiResultPrintHelper.printAndWait;

public class FeeInfoAsJsonTest {

    @SneakyThrows
    @Test
    public void json() {
        printAndWait(
                new FeeInfoAsJson().json()
        );
    }
}