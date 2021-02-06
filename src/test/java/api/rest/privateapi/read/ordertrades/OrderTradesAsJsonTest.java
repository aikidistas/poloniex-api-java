package api.rest.privateapi.read.ordertrades;

import lombok.SneakyThrows;
import org.junit.Test;

import static api.rest.ApiResultPrintHelper.printAndWait;

public class OrderTradesAsJsonTest {

    @SneakyThrows
    @Test
    public void json() {
        printAndWait(
                new OrderTradesAsJson("682824479162").json()
        );
    }
}