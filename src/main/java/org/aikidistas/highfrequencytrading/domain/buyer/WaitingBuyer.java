package org.aikidistas.highfrequencytrading.domain.buyer;

import api.rest.ApiReadException;
import api.rest.privateapi.read.orderstatus.OrderStatus;
import api.rest.privateapi.read.orderstatus.dto.OrderStatusDto;
import api.rest.privateapi.trade.ApiOrderException;
import api.rest.privateapi.trade.dto.OrderResultDto;
import lombok.extern.log4j.Log4j2;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Log4j2
public class WaitingBuyer implements Buyer {

    private final Buyer buyer;

    public WaitingBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    @Override
    public OrderResultDto buy(String currencyPair, BigDecimal price, BigDecimal amount) throws ApiOrderException {
        OrderResultDto buyResult = buyer.buy(currencyPair, price, amount);

        log.info(buyResult);

        if (buyResult == null || buyResult.orderNumber == null) {
            log.error("buy order number is null");
            return buyResult;
        }
        // get buy order statistics
        log.info(buyResult.orderNumber);

        // wait for someone to execute my buy
        OrderStatusDto orderStatus = null;
        final OrderStatus buyOrderStatusSource = new OrderStatus(buyResult.orderNumber.toString());
        try {
            orderStatus = buyOrderStatusSource.data();
        } catch (ApiReadException e) {

        }
        log.info(orderStatus);
        while (Objects.isNull(orderStatus) || orderStatus.success == 1) {
            try {
                orderStatus = buyOrderStatusSource.data();
            } catch (ApiReadException e) {
                continue;
            }
//            log.info(orderStatus);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException ex) {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException exc) {
                        exc.printStackTrace();
                    }
                }
            }
        }
        return buyResult;
    }
}
