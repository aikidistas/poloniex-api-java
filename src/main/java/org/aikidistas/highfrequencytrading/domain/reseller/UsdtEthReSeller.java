package org.aikidistas.highfrequencytrading.domain.reseller;

import api.rest.ApiReadException;
import api.rest.privateapi.read.orderstatus.OrderStatus;
import api.rest.privateapi.read.orderstatus.dto.OrderStatusDto;
import api.rest.privateapi.trade.ApiOrderException;
import api.rest.privateapi.trade.dto.OrderResultDto;
import api.rest.privateapi.trade.sell.PoloniexSellOrder;
import lombok.extern.log4j.Log4j2;
import org.aikidistas.highfrequencytrading.domain.buyer.Buyer;
import org.aikidistas.highfrequencytrading.domain.buyer.PoloniexBuyer;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Log4j2
public class UsdtEthReSeller implements ReSeller {

    private static final BigDecimal MIN_ETH_AMOUNT = new BigDecimal("0.0001");
    private static final BigDecimal MIN_USDT_AMOUNT = BigDecimal.ONE;
    private static final String USDT_ETH = "USDT_ETH";
    private static final boolean FILL_OR_KILL = false;
    private static final boolean IMMEDIATE_OR_CANCEL = false;
    private static final boolean POST_ONLY = false;
    private final Buyer.Smart buyer;
    private final BigDecimal buyPrice;
    private final BigDecimal sellPrice;
    private final BigDecimal buyEthAmount;


    public UsdtEthReSeller(BigDecimal buyPrice, BigDecimal sellPrice, BigDecimal buyEthAmount) {
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.buyEthAmount = buyEthAmount;

        buyer = new Buyer.Smart(new PoloniexBuyer());
    }

    @Override
    public void buyAndSell() {
        // TODO: new Buyer().buyHigherThanHighestBidPrice()
        OrderResultDto buyResult = null;
        try {
            buyResult = buyer.buyEthOrder(buyPrice, buyEthAmount);
        } catch (ApiOrderException e) {
            e.printStackTrace();
        }
        log.info(buyResult);

        if (buyResult == null || buyResult.orderNumber == null) {
            log.error("buy order number is null");
            return;
        }
        // get buy order statistics
        log.info(buyResult.orderNumber);

        // wait for someone to execute my buy
        OrderStatusDto orderStatus = null;
        final OrderStatus buyOrderStatusSource = new OrderStatus(buyResult.orderNumber.toString());
        try {
            orderStatus = buyOrderStatusSource.data();
        } catch (ApiReadException e) {
            e.printStackTrace();
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
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                try {
                    TimeUnit.MILLISECONDS.sleep(1000);
                } catch (InterruptedException ex) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(1000);
                    } catch (InterruptedException exc) {
                        exc.printStackTrace();
                    }
                }
            }
        }
/*
        // TODO: new ReSeller(buyer, new Seller()).getMinimumProfitableReSellPrice           // buyer.getLastBuyPrice()
        // sell for some profit. Consider buy fee + sell fee + reduced amount between buy and sell. // ---1 percent not ---minimum 0.01 usdt----- profit
        BigDecimal sellPrice = buyPrice.multiply(new BigDecimal("1.004")).setScale(8, RoundingMode.CEILING);
        // TODO: new ReSeller(buyer, new Seller()).getReSellEthAmount()
*/
        BigDecimal sellEthAmount = buyEthAmount.multiply(new BigDecimal("0.99875")).setScale(8, RoundingMode.FLOOR);

        // TODO: new ReSeller(buyer, new Seller()).reSell();

        OrderResultDto sellResult = null;
        try {
            sellResult = new PoloniexSellOrder(USDT_ETH, sellPrice, sellEthAmount).execute();
        } catch (ApiOrderException e) {
            log.error("Failed to execute sell ETH order", e);
            try {
                sellResult = new PoloniexSellOrder(USDT_ETH, sellPrice, sellEthAmount).execute();
            } catch (ApiOrderException ex) {
                log.error("Failed to execute sell ETH order (2-nd try)", e);
                try {
                    sellResult = new PoloniexSellOrder(USDT_ETH, sellPrice, sellEthAmount).execute();
                } catch (ApiOrderException exc) {
                    log.error("Failed to execute sell ETH order (2-nd try)", e);
                    System.exit(500);
                }
            }
        }


        log.info(sellResult);

        // wait for someone to execute my sell
        OrderStatusDto sellOrderStatus = null;
        final OrderStatus sellOrderStatusSource = new OrderStatus(sellResult.orderNumber.toString());
        try {
            sellOrderStatus = sellOrderStatusSource.data();
        } catch (ApiReadException e) {
            e.printStackTrace();
        }
        log.info(sellOrderStatus);
        while (Objects.isNull(sellOrderStatus) || sellOrderStatus.success == 1) { // TODO: 2021-01-30 11:23:40,821 [main] ERROR PoloniexPrivateObjectApi - Error retrieving order status for 681686569211 - null     Exception in thread "main" java.lang.NullPointerException              at org.aikidistas.highfrequencytrading.OneCentProfitTraderApp_BROKEN_BUY_AND_STOP_ON_NULL.run(OneCentProfitTraderApp_BROKEN_BUY_AND_STOP_ON_NULL.java:113)       at org.aikidistas.highfrequencytrading.OneCentProfitTraderApp_BROKEN_BUY_AND_STOP_ON_NULL.main(OneCentProfitTraderApp_BROKEN_BUY_AND_STOP_ON_NULL.java:39)
            try {
                sellOrderStatus = sellOrderStatusSource.data();
            } catch (ApiReadException e) {
                continue;
            }
            ////            log.info(sellOrderStatus);
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                try {
                    TimeUnit.MILLISECONDS.sleep(1000);
                } catch (InterruptedException ex) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(1000);
                    } catch (InterruptedException exc) {
                        exc.printStackTrace();
                    }
                }
            }
        }
    }
}
