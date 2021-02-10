package api.rest.privateapi.read.ordertrades;

import api.rest.privateapi.read.ordertrades.dto.OrderTradeDto;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static api.rest.ApiResultPrintHelper.printAndWait;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderTradesTest {


    @SneakyThrows
    @Test
    public void mapOrderTrades() {
        String data = "[{\"globalTradeID\": 20825863, \"tradeID\": 147142, \"currencyPair\": \"BTC_XVC\", \"type\": \"buy\", \"rate\": \"0.00018500\", \"amount\": \"455.34206390\", \"total\": \"0.08423828\", \"fee\": \"0.00200000\", \"date\": \"2016-03-14 01:04:36\"}, {\"globalTradeID\": 20825864, \"tradeID\": 147143, \"currencyPair\": \"BTC_XVC\", \"type\": \"buy\", \"rate\": \"0.00018500\", \"amount\": \"455.34206390\", \"total\": \"0.08423828\", \"fee\": \"0.00200000\", \"date\": \"2016-03-14 01:04:36\"}]";
        List<OrderTradeDto> orderTrades = new OrderTrades(() -> data).data();  //mapper.mapOrderTrades(data);
        assertEquals(2, orderTrades.size());

        OrderTradeDto first = orderTrades.get(0);
        assertEquals(20825863L, first.globalTradeID.longValue());
        assertEquals(147142L, first.tradeID.longValue());
        assertEquals("2016-03-14T01:04:36Z", first.date.toString());
        assertEquals("0.00018500", first.rate.toPlainString());
        assertEquals("0.00200000", first.fee.toPlainString());
        assertEquals("buy", first.type);
        assertEquals("BTC_XVC", first.currencyPair);
    }

    @Test
    public void throwsExceptionOnInvalidOrderNumber() {
        Assertions.assertThrows(Exception.class, () -> {
            String orderNumber = "123";
            printAndWait(
                    new OrderTrades(orderNumber).data()
            );
        });
    }
}