package org.aikidistas.highfrequencytrading;

import api.rest.ApiReadException;
import api.rest.privateapi.read.openorders.OpenOrders;
import api.rest.privateapi.read.openorders.dto.OpenOrderDto;
import lombok.extern.log4j.Log4j2;
import org.aikidistas.utils.Sleep;

import java.util.List;

@Log4j2
public class OpenOrdersInfoApp {
    public static void main(String... args) throws InterruptedException {
        final String usdtEth = "USDT_ETH";
        while (true) {

            List<OpenOrderDto> orders = null; // TODO: {"orderNumber":"681683435348","type":"sell","rate":1354.98760672,"amount":0.00074097,"total":1.00400516}            2021-01-30 11:39:59,369 [main] ERROR PoloniexPrivateObjectApi - Error retrieving open orders for USDT_ETH - java.lang.IllegalStateException: Expected BEGIN_ARRAY but was BEGIN_OBJECT at line 1 column 2 path $
            try {
                orders = new OpenOrders(usdtEth).data();
            } catch (ApiReadException e) {
                continue;
            }
            System.out.println("================================================================================================================================");
            orders.forEach(System.out::println);
            Sleep.seconds(10);
        }
    }
}
