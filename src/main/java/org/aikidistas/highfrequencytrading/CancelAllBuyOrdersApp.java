package org.aikidistas.highfrequencytrading;

import api.rest.ApiReadException;
import api.rest.privateapi.read.openorders.OpenOrders;
import api.rest.privateapi.read.openorders.dto.OpenOrderDto;
import api.rest.privateapi.trade.ApiOrderException;
import api.rest.privateapi.trade.cancel.CancelOrderOrderImpl;
import lombok.extern.log4j.Log4j2;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Log4j2
public class CancelAllBuyOrdersApp implements App {
    public static void main(String... args) {
        App app = new CancelAllBuyOrdersApp();
        app.run();
    }

    @Override
    public void run() {
        final String usdtEth = "USDT_ETH";

        List<OpenOrderDto> orders; // TODO: {"orderNumber":"681683435348","type":"sell","rate":1354.98760672,"amount":0.00074097,"total":1.00400516}            2021-01-30 11:39:59,369 [main] ERROR PoloniexPrivateObjectApi - Error retrieving open orders for USDT_ETH - java.lang.IllegalStateException: Expected BEGIN_ARRAY but was BEGIN_OBJECT at line 1 column 2 path $
        try {
            orders = new OpenOrders(usdtEth).data();
        } catch (ApiReadException e) {
            log.error(e);
            return;
        }

        System.out.println("================================================================================================================================");
        System.out.println("==  FOUND ORDERS ===============================================================================================================");
        orders.forEach(System.out::println);

        System.out.println();
        System.out.println("================================================================================================================================");
        System.out.println("==  CANCELLED ORDERS ===============================================================================================================");

        orders.stream()
                .filter(Objects::nonNull)
                .filter(o -> "buy".equals(o.type))
                .filter(o -> Objects.nonNull(o.orderNumber))
                .forEach(o -> {
                    try {
                        new CancelOrderOrderImpl(o.orderNumber).execute();
                        System.out.println(o);
                        TimeUnit.MILLISECONDS.sleep(200);
                    } catch (InterruptedException | ApiOrderException e) {
                        e.printStackTrace();
                    }
                });
    }
}