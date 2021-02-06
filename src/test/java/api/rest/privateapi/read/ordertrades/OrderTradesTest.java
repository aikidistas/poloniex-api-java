package api.rest.privateapi.read.ordertrades;

import lombok.SneakyThrows;
import org.junit.Test;

import static api.rest.ApiResultPrintHelper.printAndWait;

public class OrderTradesTest {

    @SneakyThrows
    @Test
    public void data() {
        String orderNumber = "123";
        printAndWait(
                new OrderTrades(orderNumber).data()
        );
    }
}