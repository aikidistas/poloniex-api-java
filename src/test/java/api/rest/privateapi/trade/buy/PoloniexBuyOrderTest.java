package api.rest.privateapi.trade.buy;

import api.rest.privateapi.trade.dto.OrderResultDto;
import api.rest.privateapi.trade.trade.PoloniexTradeOrder;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class PoloniexBuyOrderTest {
    @SneakyThrows
    @Test
    public void mapBuyTradeOrder() {
        String data = "{\"orderNumber\":31226040,\"resultingTrades\":[{\"amount\":\"338.8732\",\"date\":\"2014-10-18 23:03:21\",\"rate\":\"0.00000173\",\"total\":\"0.00058625\",\"tradeID\":\"16164\",\"type\":\"buy\"}]}";

        OrderResultDto orderResult = new PoloniexBuyOrder(new PoloniexTradeOrder(() -> data)).execute();
        assertEquals(31226040L, orderResult.orderNumber.longValue());
        assertEquals(1, orderResult.resultingTrades.size());
        assertEquals(BigDecimal.valueOf(338.8732), orderResult.resultingTrades.get(0).amount);
        assertEquals("2014-10-18T23:03:21Z", orderResult.resultingTrades.get(0).date.toString());
        assertEquals(BigDecimal.valueOf(0.00000173), orderResult.resultingTrades.get(0).rate);
        assertEquals(BigDecimal.valueOf(0.00058625), orderResult.resultingTrades.get(0).total);
        assertEquals("16164", orderResult.resultingTrades.get(0).tradeID);
        assertEquals("buy", orderResult.resultingTrades.get(0).type);
        assertNull(orderResult.error);
    }

    @SneakyThrows
    @Test
    public void mapFailedBuyTradeOrderWithError() {
        String data = "{\"error\":\"Unable to fill order completely.\"}";
        OrderResultDto orderResult = new PoloniexBuyOrder(new PoloniexTradeOrder(() -> data)).execute(); //mapper.mapTradeOrder(data);
        assertNull(orderResult.orderNumber);
        assertNull(orderResult.resultingTrades);
        assertNotNull(orderResult.error);
    }

}