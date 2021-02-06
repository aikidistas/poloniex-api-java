package api.rest.privateapi.read.orderstatus;

import lombok.SneakyThrows;
import org.junit.Test;

import static api.rest.ApiResultPrintHelper.printAndWait;

public class OrderStatusAsJsonTest {

    @SneakyThrows
    @Test
    public void json() {
        printAndWait(
                new OrderStatusAsJson("682780995689").json()
        );
    }
}