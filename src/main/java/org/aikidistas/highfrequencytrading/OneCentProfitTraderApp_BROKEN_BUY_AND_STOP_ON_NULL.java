package org.aikidistas.highfrequencytrading;


import api.rest.privateapi.read.orderstatus.OrderStatus;
import api.rest.privateapi.read.orderstatus.dto.OrderStatusDto;
import api.rest.privateapi.trade.dto.OrderResultDto;
import api.rest.privateapi.trade.sell.PoloniexSellOrder;
import api.rest.publicapi.read.ticker.Ticker;
import api.rest.publicapi.read.ticker.TickerData;
import api.rest.publicapi.read.ticker.dto.TickerDto;
import lombok.extern.log4j.Log4j2;
import org.aikidistas.highfrequencytrading.domain.buyer.Buyer;
import org.aikidistas.highfrequencytrading.domain.buyer.PoloniexBuyer;
import org.aikidistas.highfrequencytrading.domain.buyer.WaitingBuyer;
import org.aikidistas.utils.Sleep;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;


/**
 * // seller price     - higher    - lowestAsk
 * // buyer price      - lower     - highestBid
 * // sellerPrice - 1      // uzlendu parduodant (sellinant)
 * // buyerPrice + 1       // uzlendu perkant    (buyinant)
 */
@Log4j2
public class OneCentProfitTraderApp_BROKEN_BUY_AND_STOP_ON_NULL implements App {


    public static final BigDecimal MIN_ETH_AMOUNT = new BigDecimal("0.0001");
    public static final BigDecimal MIN_USDT_AMOUNT = BigDecimal.ONE;
    public static final String USDT_ETH = "USDT_ETH";
    public static final boolean FILL_OR_KILL = false;
    public static final boolean IMMEDIATE_OR_CANCEL = false;
    public static final boolean POST_ONLY = false;
    private final Buyer.Smart buyer;

    public OneCentProfitTraderApp_BROKEN_BUY_AND_STOP_ON_NULL() {
        buyer = new Buyer.Smart(new WaitingBuyer(new PoloniexBuyer()));
    }

    public static void main(String[] args) {
        App app = new OneCentProfitTraderApp_BROKEN_BUY_AND_STOP_ON_NULL();
        app.run();
    }

    @Override
    public void run() {

        while (true) {

            // TODO:BigDecimal highestBid = new CashedTicker(new Ticker()).highestBid(USDT_ETH);
            // get ticker info
            TickerDto ticker;
            try {
                ticker = new TickerData.Smart(new Ticker()).data(USDT_ETH);
            } catch (Exception e) {
                continue;
            }
            log.info(ticker.toString());

            // TODO: BigDecimal buyPrice = new Buyer(new CashedTicker(new Ticker)).highestBidPrice
            // buy - highestBid + 0.00000001 = buyerPrice + 0.00000001       // uzlendu perkant    (buyinant)
            BigDecimal buyPrice = ticker.highestBid.add(new BigDecimal("0.00000001"));
            log.info(buyPrice.setScale(8, RoundingMode.CEILING).toPlainString());


            // TODO: new Buyer().buyHigherThanHighestBidPrice()
            OrderResultDto buyResult;
            try {
                buyResult = buyer.buyMinimumEthAmountOrder(buyPrice);
            } catch (Exception e) {
                continue;
            }
            if (Objects.isNull(buyResult) || Objects.isNull(buyResult.orderNumber)) {
                log.error("buy order number is null");
                continue;
            }

            log.info(buyResult.toString());

            // get buy order statistics
            log.info(buyResult.orderNumber);

            // wait for someone to execute my buy
            OrderStatusDto orderStatus = null;
            final OrderStatus orderStatusSource = new OrderStatus(buyResult.orderNumber.toString());
            try {
                orderStatus = orderStatusSource.data();
            } catch (Exception e) {
                e.printStackTrace();
            }
            log.info(orderStatus);
            while (orderStatus == null || orderStatus.success == 1) {
                try {
                    orderStatus = orderStatusSource.data();
                } catch (Exception e) {
                    continue;
                }
                Sleep.seconds(1);

            }

            // TODO: new ReSeller(buyer, new Seller()).getMinimumProfitableReSellPrice           // buyer.getLastBuyPrice()
            // sell for some profit. Consider buy fee + sell fee + reduced amount between buy and sell. // ---1 percent not ---minimum 0.01 usdt----- profit
            BigDecimal sellPrice = buyPrice.multiply(new BigDecimal("1.004")).setScale(8, RoundingMode.CEILING);


            // TO DO: BigDecimal buyEthAmount = new IncreaseEthAmountToMinimumBuyer(new Buyer(new Ticker)).minEthAmount      // Can also create class CancelBuyOnLessThanMinimumEthBuyer(Buyer b)
            BigDecimal buyEthAmount = buyer.minimumEthAmount(buyPrice);
            // TODO: new ReSeller(buyer, new Seller()).getReSellEthAmount()
            BigDecimal sellEthAmount = buyEthAmount.multiply(new BigDecimal("0.99875")).setScale(8, RoundingMode.FLOOR);

            // TODO: new ReSeller(buyer, new Seller()).reSell();
            OrderResultDto sellResult = null;
            try {
                sellResult = new PoloniexSellOrder(USDT_ETH, sellPrice, sellEthAmount).execute();
            } catch (Exception e) {
                log.error("Failed to execute sell ETH order", e);
                try {
                    sellResult = new PoloniexSellOrder(USDT_ETH, sellPrice, sellEthAmount).execute();
                } catch (Exception ex) {
                    log.error("Failed to execute sell ETH order (2-nd try)", e);
                    try {
                        sellResult = new PoloniexSellOrder(USDT_ETH, sellPrice, sellEthAmount).execute();
                    } catch (Exception exc) {
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
            } catch (Exception e) {
                e.printStackTrace();
            }
            log.info(sellOrderStatus);
            while (sellOrderStatus != null && sellOrderStatus.success == 1) { // TODO: 2021-01-30 11:23:40,821 [main] ERROR PoloniexPrivateObjectApi - Error retrieving order status for 681686569211 - null     Exception in thread "main" java.lang.NullPointerException              at org.aikidistas.highfrequencytrading.OneCentProfitTraderApp_BROKEN_BUY_AND_STOP_ON_NULL.run(OneCentProfitTraderApp_BROKEN_BUY_AND_STOP_ON_NULL.java:113)       at org.aikidistas.highfrequencytrading.OneCentProfitTraderApp_BROKEN_BUY_AND_STOP_ON_NULL.main(OneCentProfitTraderApp_BROKEN_BUY_AND_STOP_ON_NULL.java:39)
                try {
                    sellOrderStatus = sellOrderStatusSource.data();
                } catch (Exception e) {
                    break;
                }
                ////            log.info(sellOrderStatus);
                Sleep.seconds(1); // TODO: handle SIGINT. exit from main. see if it was while buy, or while sell. if it was buy order, maybe cancel order, and retry to {buy and sell}
            }
        }
    }
}


// 2021-01-27 15:57:58,418 [main] TRACE PoloniexPrivateObjectApi - Executed and mapped USDT_ETH buy order {"error":"Permission denied."} in 1210 ms
