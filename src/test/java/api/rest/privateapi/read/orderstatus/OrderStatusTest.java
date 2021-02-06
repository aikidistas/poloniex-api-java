package api.rest.privateapi.read.orderstatus;

import lombok.SneakyThrows;
import org.junit.Test;

import static api.rest.ApiResultPrintHelper.printAndWait;

public class OrderStatusTest {

    @SneakyThrows
    @Test
    public void data() {
        printAndWait(
                new OrderStatus("123").data()
        );
    }
}