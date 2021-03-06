package org.aikidistas.highfrequencytrading.domain.buyer;


import api.rest.privateapi.read.orderstatus.OrderStatus;
import api.rest.privateapi.trade.dto.OrderResultDto;
import lombok.extern.log4j.Log4j2;
import org.aikidistas.utils.Sleep;

import java.math.BigDecimal;

@Log4j2
public class WaitingBuyer implements Buyer {

    private final Buyer buyer;

    public WaitingBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    @Override
    public OrderResultDto buy(String currencyPair, BigDecimal price, BigDecimal amount) throws Exception {
        OrderResultDto buyResult = buyer.buy(currencyPair, price, amount);

        final OrderStatus orderStatusSource = new OrderStatus(buyResult.orderNumber);

        while (true) {
            try {
                orderStatusSource.data(); // while I can receive order status, it means it is's trades are not completely finished
            } catch (Exception e) {
                // when information about order status is not received, It means order was executed
                break;
            }
            Sleep.seconds(1);
        }

        // TODO: update resulted trades from new api call, before returning this value. This way, we will always have executed trades returned
        return buyResult;
    }
}
