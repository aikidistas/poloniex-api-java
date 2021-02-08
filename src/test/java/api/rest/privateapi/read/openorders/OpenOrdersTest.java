package api.rest.privateapi.read.openorders;

import api.rest.privateapi.read.openorders.dto.OpenOrderDto;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OpenOrdersTest {

    @SneakyThrows
    @Test
    public void mapEmptyOpenOrders() {
        String data = "[]";
        List<OpenOrderDto> openOrders = new OpenOrders(() -> data).data(); //mapper.mapOpenOrders(data);
        assertTrue(openOrders.isEmpty());
    }

    @SneakyThrows
    @Test
    public void mapSingleOpenOrder() {
        String openOrderResults = "[{\"orderNumber\":\"117741833082\",\"type\":\"sell\",\"rate\":\"277.79999987\",\"startingAmount\":\"0.73815000\",\"amount\":\"0.73815000\",\"total\":\"205.05806990\",\"date\":\"2017-07-04 14:24:22\",\"margin\":0}]";
        List<OpenOrderDto> openOrders = new OpenOrders(() -> openOrderResults).data();  //mapper.mapOpenOrders(openOrderResults);
        assertEquals(1, openOrders.size());

        OpenOrderDto openOrder = openOrders.get(0);
        assertEquals(new BigDecimal("0.73815000"), openOrder.amount);
        assertEquals("117741833082", openOrder.orderNumber);
        assertEquals(new BigDecimal("277.79999987"), openOrder.rate);
        assertEquals(new BigDecimal("205.05806990"), openOrder.total);
        assertEquals("sell", openOrder.type);
    }

    @SneakyThrows
    @Test
    public void mapMultipleOpenOrders() {
        String data = "[{\"orderNumber\":\"120466\",\"type\":\"sell\",\"rate\":\"0.025\",\"amount\":\"100\",\"total\":\"2.5\"},{\"orderNumber\":\"120467\",\"type\":\"sell\",\"rate\":\"0.04\",\"amount\":\"100\",\"total\":\"4\"}]";
        List<OpenOrderDto> openOrders = new OpenOrders(() -> data).data(); //mapper.mapOpenOrders(data);
        assertEquals(2, openOrders.size());
    }

}