package org.aikidistas.highfrequencytrading.domain.seller;


import api.rest.privateapi.read.orderstatus.OrderStatus;
import api.rest.privateapi.trade.dto.OrderResultDto;
import lombok.extern.log4j.Log4j2;
import org.aikidistas.utils.Sleep;

import java.math.BigDecimal;

// TODO: create WaitingTrader (for sell and buy orders)
@Log4j2
public class WaitingSeller implements Seller {

    private final Seller seller;

    public WaitingSeller(Seller seller) {
        this.seller = seller;
    }

    @Override
    public OrderResultDto sell(String currencyPair, BigDecimal price, BigDecimal amount) throws Exception {
        OrderResultDto sellResult = seller.sell(currencyPair, price, amount);

        final OrderStatus orderStatusSource = new OrderStatus(sellResult.orderNumber);

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
        return sellResult;
    }
}
