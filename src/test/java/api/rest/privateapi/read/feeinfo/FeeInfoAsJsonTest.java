package api.rest.privateapi.read.feeinfo;

import lombok.SneakyThrows;
import org.junit.Test;

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