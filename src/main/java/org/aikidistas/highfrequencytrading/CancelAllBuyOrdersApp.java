package org.aikidistas.highfrequencytrading;


import api.rest.privateapi.read.openorders.OpenOrders;
import api.rest.privateapi.read.openorders.dto.OpenOrderDto;
import api.rest.privateapi.trade.cancel.PoloniexCancelOrder;
import lombok.extern.log4j.Log4j2;
import org.aikidistas.utils.Sleep;

import java.util.List;
import java.util.Objects;

@Log4j2
public class CancelAllBuyOrdersApp implements App {

    public static final String USDT_ETH = "USDT_ETH";

    public static void main(String... args) {
        App app = new CancelAllBuyOrdersApp();
        app.run();
    }

    @Override
    public void run() {
        try {
            cancelAllBuyOrders();
        } catch (Exception e) {
            log.error("Couldn't cancel all buy orders", e);
        }
    }

    private void cancelAllBuyOrders() throws Exception {
        List<OpenOrderDto> orders = new OpenOrders(USDT_ETH).data();

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
                        new PoloniexCancelOrder(o.orderNumber).execute();
                        System.out.println(o);
                        Sleep.milliseconds(200);
                    } catch (Exception e) {
                        log.warn("Couldn't cancel order nr: " + o.orderNumber + ". ", e);
                    }
                });
    }
}
