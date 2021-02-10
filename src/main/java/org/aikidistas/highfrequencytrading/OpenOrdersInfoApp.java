package org.aikidistas.highfrequencytrading;


import api.rest.privateapi.read.openorders.OpenOrders;
import api.rest.privateapi.read.openorders.dto.OpenOrderDto;
import lombok.extern.log4j.Log4j2;
import org.aikidistas.utils.Sleep;

import java.util.List;

@Log4j2
public class OpenOrdersInfoApp implements App {

    public static final String USDT_ETH = "USDT_ETH";

    public static void main(String... args) {
        new OpenOrdersInfoApp().run();
    }

    @Override
    public void run() {
        try {
            continuouslyPrintOpenOrders();
        } catch (Exception e) {
            log.error("failed to continuously print open orders", e);
        }
    }

    private void continuouslyPrintOpenOrders() throws Exception {
        while (true) {
            printOpenOrders();
        }
    }

    private void printOpenOrders() throws Exception {
        List<OpenOrderDto> orders = new OpenOrders(USDT_ETH).data();
        System.out.println("================================================================================================================================");
        orders.forEach(System.out::println);
        Sleep.seconds(10);
    }
}
