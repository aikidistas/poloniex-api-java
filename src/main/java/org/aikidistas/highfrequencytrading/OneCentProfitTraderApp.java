package org.aikidistas.highfrequencytrading;


import api.rest.publicapi.read.ticker.Ticker;
import lombok.extern.log4j.Log4j2;
import org.aikidistas.highfrequencytrading.domain.Multiplication;
import org.aikidistas.highfrequencytrading.domain.Sum;
import org.aikidistas.highfrequencytrading.domain.buyer.Buyer;
import org.aikidistas.highfrequencytrading.domain.buyer.PoloniexBuyer;
import org.aikidistas.highfrequencytrading.domain.buyer.WaitingBuyer;
import org.aikidistas.highfrequencytrading.domain.seller.PoloniexSeller;
import org.aikidistas.highfrequencytrading.domain.seller.Seller;
import org.aikidistas.highfrequencytrading.domain.seller.WaitingSeller;

import java.math.BigDecimal;


/**
 * // seller price     - higher    - lowestAsk
 * // buyer price      - lower     - highestBid
 * // sellerPrice - 1      // uzlendu parduodant (sellinant)
 * // buyerPrice + 1       // uzlendu perkant    (buyinant)
 */
@Log4j2
public class OneCentProfitTraderApp implements App {


    public static final String USDT_ETH = "USDT_ETH";
    public static final BigDecimal MINIMUM_NUMBER_INCREMENT = new BigDecimal("0.00000001");
    private final Buyer.Smart waitingBuyer = new Buyer.Smart(new WaitingBuyer(new PoloniexBuyer()));
    private final Seller.Smart waitingSeller = new Seller.Smart(new WaitingSeller(new PoloniexSeller()));

    public static void main(String[] args) {
        App app = new OneCentProfitTraderApp();
        app.run();
    }

    @Override
    public void run() {
        try {
            continuouslyBuyAndSell();
        } catch (Exception e) {
            log.error("Failed to continuously buy and sell with minimum profit", e);
        }
    }

    private void continuouslyBuyAndSell() throws Exception {
        while (true) {
            buyAndSell();
        }
    }

    private void buyAndSell() throws Exception {

        BigDecimal buyPrice = new Sum(
                new Ticker.Smart(new Ticker()).usdtEthTicker().highestBid,
                MINIMUM_NUMBER_INCREMENT
        ).value();

        // TODO: new ReSeller(buyer, new Seller()).reSell();
        //======================================
        // BUY               and wait for completed trades
        waitingBuyer.buyMinimumEthAmountOrder(buyPrice);
        System.out.println("==============================");
        System.out.println("BUY [" + waitingBuyer.minimumEthAmount(buyPrice) + "] eth for price: " + buyPrice);


        BigDecimal buyEthAmount = waitingBuyer.minimumEthAmount(buyPrice);

        //===================================================
        // SELL
        final BigDecimal sellPrice = new Multiplication(
                buyPrice,
                new BigDecimal("1.004")
        ).value();
        final BigDecimal sellAmount = new Multiplication(
                buyEthAmount,
                new BigDecimal("0.99875")
        ).value();
        waitingSeller.sellEthOrder(sellPrice, sellAmount);

        System.out.println("==============================");
        System.out.println("SELL [ " + sellAmount + " ] eth for price: " + sellPrice);
    }
}


// 2021-01-27 15:57:58,418 [main] TRACE PoloniexPrivateObjectApi - Executed and mapped USDT_ETH buy order {"error":"Permission denied."} in 1210 ms

/*
================================================================================================================================
OpenOrderDto(orderNumber=691385510561, type=sell, rate=1730.46350083, amount=0.00057947, total=1.00275168)
================================================================================================================================
OpenOrderDto(orderNumber=691385510561, type=sell, rate=1730.46350083, amount=0.00057947, total=1.00275168)
================================================================================================================================
OpenOrderDto(orderNumber=691385510561, type=sell, rate=1730.46350083, amount=0.00057947, total=1.00275168)
================================================================================================================================
OpenOrderDto(orderNumber=691385510561, type=sell, rate=1730.46350083, amount=0.00057947, total=1.00275168)
================================================================================================================================
OpenOrderDto(orderNumber=691385510561, type=sell, rate=1730.46350083, amount=0.00057947, total=1.00275168)
================================================================================================================================
OpenOrderDto(orderNumber=691385510561, type=sell, rate=1730.46350083, amount=0.00057947, total=1.00275168)
================================================================================================================================
OpenOrderDto(orderNumber=691385510561, type=sell, rate=1730.46350083, amount=0.00057947, total=1.00275168)
================================================================================================================================
OpenOrderDto(orderNumber=691385510561, type=sell, rate=1730.46350083, amount=0.00057947, total=1.00275168)
================================================================================================================================
OpenOrderDto(orderNumber=691386493577, type=buy, rate=1722.17381699, amount=0.00058067, total=1.00001467)
OpenOrderDto(orderNumber=691385510561, type=sell, rate=1730.46350083, amount=0.00057947, total=1.00275168)
================================================================================================================================
OpenOrderDto(orderNumber=691386493577, type=buy, rate=1722.17381699, amount=0.00058067, total=1.00001467)
OpenOrderDto(orderNumber=691385510561, type=sell, rate=1730.46350083, amount=0.00057947, total=1.00275168)
================================================================================================================================
OpenOrderDto(orderNumber=691386493577, type=buy, rate=1722.17381699, amount=0.00058067, total=1.00001467)
OpenOrderDto(orderNumber=691385510561, type=sell, rate=1730.46350083, amount=0.00057947, total=1.00275168)
================================================================================================================================
OpenOrderDto(orderNumber=691386493577, type=buy, rate=1722.17381699, amount=0.00058067, total=1.00001467)
OpenOrderDto(orderNumber=691385510561, type=sell, rate=1730.46350083, amount=0.00057947, total=1.00275168)
================================================================================================================================
OpenOrderDto(orderNumber=691386493577, type=buy, rate=1722.17381699, amount=0.00058067, total=1.00001467)
OpenOrderDto(orderNumber=691385510561, type=sell, rate=1730.46350083, amount=0.00057947, total=1.00275168)
================================================================================================================================
OpenOrderDto(orderNumber=691386493577, type=buy, rate=1722.17381699, amount=0.00058067, total=1.00001467)
OpenOrderDto(orderNumber=691385510561, type=sell, rate=1730.46350083, amount=0.00057947, total=1.00275168)
================================================================================================================================
OpenOrderDto(orderNumber=691386493577, type=buy, rate=1722.17381699, amount=0.00058067, total=1.00001467)
OpenOrderDto(orderNumber=691385510561, type=sell, rate=1730.46350083, amount=0.00057947, total=1.00275168)
================================================================================================================================
OpenOrderDto(orderNumber=691386493577, type=buy, rate=1722.17381699, amount=0.00058067, total=1.00001467)
OpenOrderDto(orderNumber=691385510561, type=sell, rate=1730.46350083, amount=0.00057947, total=1.00275168)
================================================================================================================================
OpenOrderDto(orderNumber=691386666404, type=sell, rate=1729.06251226, amount=0.00057994, total=1.00275251)
OpenOrderDto(orderNumber=691385510561, type=sell, rate=1730.46350083, amount=0.00057947, total=1.00275168)
================================================================================================================================
OpenOrderDto(orderNumber=691386666404, type=sell, rate=1729.06251226, amount=0.00057994, total=1.00275251)
OpenOrderDto(orderNumber=691385510561, type=sell, rate=1730.46350083, amount=0.00057947, total=1.00275168)
================================================================================================================================
OpenOrderDto(orderNumber=691386666404, type=sell, rate=1729.06251226, amount=0.00057994, total=1.00275251)
OpenOrderDto(orderNumber=691385510561, type=sell, rate=1730.46350083, amount=0.00057947, total=1.00275168)
================================================================================================================================
OpenOrderDto(orderNumber=691386666404, type=sell, rate=1729.06251226, amount=0.00057994, total=1.00275251)
OpenOrderDto(orderNumber=691385510561, type=sell, rate=1730.46350083, amount=0.00057947, total=1.00275168)
================================================================================================================================
OpenOrderDto(orderNumber=691386666404, type=sell, rate=1729.06251226, amount=0.00057994, total=1.00275251)
OpenOrderDto(orderNumber=691385510561, type=sell, rate=1730.46350083, amount=0.00057947, total=1.00275168)
================================================================================================================================
OpenOrderDto(orderNumber=691386666404, type=sell, rate=1729.06251226, amount=0.00057994, total=1.00275251)
OpenOrderDto(orderNumber=691385510561, type=sell, rate=1730.46350083, amount=0.00057947, total=1.00275168)
================================================================================================================================
OpenOrderDto(orderNumber=691386666404, type=sell, rate=1729.06251226, amount=0.00057994, total=1.00275251)
OpenOrderDto(orderNumber=691385510561, type=sell, rate=1730.46350083, amount=0.00057947, total=1.00275168)
================================================================================================================================
OpenOrderDto(orderNumber=691386666404, type=sell, rate=1729.06251226, amount=0.00057994, total=1.00275251)
OpenOrderDto(orderNumber=691385510561, type=sell, rate=1730.46350083, amount=0.00057947, total=1.00275168)
================================================================================================================================
OpenOrderDto(orderNumber=691386666404, type=sell, rate=1729.06251226, amount=0.00057994, total=1.00275251)
OpenOrderDto(orderNumber=691385510561, type=sell, rate=1730.46350083, amount=0.00057947, total=1.00275168)
================================================================================================================================
OpenOrderDto(orderNumber=691386666404, type=sell, rate=1729.06251226, amount=0.00057994, total=1.00275251)
OpenOrderDto(orderNumber=691385510561, type=sell, rate=1730.46350083, amount=0.00057947, total=1.00275168)
================================================================================================================================
OpenOrderDto(orderNumber=691386666404, type=sell, rate=1729.06251226, amount=0.00057994, total=1.00275251)
OpenOrderDto(orderNumber=691385510561, type=sell, rate=1730.46350083, amount=0.00057947, total=1.00275168)
================================================================================================================================
OpenOrderDto(orderNumber=691386666404, type=sell, rate=1729.06251226, amount=0.00057994, total=1.00275251)
OpenOrderDto(orderNumber=691385510561, type=sell, rate=1730.46350083, amount=0.00057947, total=1.00275168)
================================================================================================================================
OpenOrderDto(orderNumber=691386666404, type=sell, rate=1729.06251226, amount=0.00057994, total=1.00275251)
OpenOrderDto(orderNumber=691385510561, type=sell, rate=1730.46350083, amount=0.00057947, total=1.00275168)
================================================================================================================================
OpenOrderDto(orderNumber=691386666404, type=sell, rate=1729.06251226, amount=0.00057994, total=1.00275251)
OpenOrderDto(orderNumber=691385510561, type=sell, rate=1730.46350083, amount=0.00057947, total=1.00275168)
================================================================================================================================
OpenOrderDto(orderNumber=691386666404, type=sell, rate=1729.06251226, amount=0.00057994, total=1.00275251)
OpenOrderDto(orderNumber=691385510561, type=sell, rate=1730.46350083, amount=0.00057947, total=1.00275168)
================================================================================================================================
OpenOrderDto(orderNumber=691386666404, type=sell, rate=1729.06251226, amount=0.00057994, total=1.00275251)
OpenOrderDto(orderNumber=691385510561, type=sell, rate=1730.46350083, amount=0.00057947, total=1.00275168)
================================================================================================================================
OpenOrderDto(orderNumber=691386666404, type=sell, rate=1729.06251226, amount=0.00057994, total=1.00275251)
OpenOrderDto(orderNumber=691385510561, type=sell, rate=1730.46350083, amount=0.00057947, total=1.00275168)
================================================================================================================================
OpenOrderDto(orderNumber=691386666404, type=sell, rate=1729.06251226, amount=0.00057994, total=1.00275251)
OpenOrderDto(orderNumber=691385510561, type=sell, rate=1730.46350083, amount=0.00057947, total=1.00275168)
================================================================================================================================
OpenOrderDto(orderNumber=691386666404, type=sell, rate=1729.06251226, amount=0.00057994, total=1.00275251)
OpenOrderDto(orderNumber=691385510561, type=sell, rate=1730.46350083, amount=0.00057947, total=1.00275168)
================================================================================================================================
OpenOrderDto(orderNumber=691386666404, type=sell, rate=1729.06251226, amount=0.00057994, total=1.00275251)
OpenOrderDto(orderNumber=691385510561, type=sell, rate=1730.46350083, amount=0.00057947, total=1.00275168)
================================================================================================================================
OpenOrderDto(orderNumber=691386666404, type=sell, rate=1729.06251226, amount=0.00057994, total=1.00275251)
OpenOrderDto(orderNumber=691385510561, type=sell, rate=1730.46350083, amount=0.00057947, total=1.00275168)
================================================================================================================================
OpenOrderDto(orderNumber=691386666404, type=sell, rate=1729.06251226, amount=0.00057994, total=1.00275251)
OpenOrderDto(orderNumber=691385510561, type=sell, rate=1730.46350083, amount=0.00057947, total=1.00275168)
================================================================================================================================
OpenOrderDto(orderNumber=691386666404, type=sell, rate=1729.06251226, amount=0.00057994, total=1.00275251)
OpenOrderDto(orderNumber=691385510561, type=sell, rate=1730.46350083, amount=0.00057947, total=1.00275168)
================================================================================================================================
OpenOrderDto(orderNumber=691386666404, type=sell, rate=1729.06251226, amount=0.00057994, total=1.00275251)
OpenOrderDto(orderNumber=691385510561, type=sell, rate=1730.46350083, amount=0.00057947, total=1.00275168)
================================================================================================================================
OpenOrderDto(orderNumber=691386666404, type=sell, rate=1729.06251226, amount=0.00057994, total=1.00275251)
OpenOrderDto(orderNumber=691385510561, type=sell, rate=1730.46350083, amount=0.00057947, total=1.00275168)
================================================================================================================================
OpenOrderDto(orderNumber=691386666404, type=sell, rate=1729.06251226, amount=0.00057994, total=1.00275251)
OpenOrderDto(orderNumber=691385510561, type=sell, rate=1730.46350083, amount=0.00057947, total=1.00275168)
================================================================================================================================
OpenOrderDto(orderNumber=691386666404, type=sell, rate=1729.06251226, amount=0.00057994, total=1.00275251)
OpenOrderDto(orderNumber=691385510561, type=sell, rate=1730.46350083, amount=0.00057947, total=1.00275168)
================================================================================================================================
OpenOrderDto(orderNumber=691386666404, type=sell, rate=1729.06251226, amount=0.00057994, total=1.00275251)
OpenOrderDto(orderNumber=691385510561, type=sell, rate=1730.46350083, amount=0.00057947, total=1.00275168)
================================================================================================================================
OpenOrderDto(orderNumber=691386666404, type=sell, rate=1729.06251226, amount=0.00057994, total=1.00275251)
OpenOrderDto(orderNumber=691385510561, type=sell, rate=1730.46350083, amount=0.00057947, total=1.00275168)
================================================================================================================================
OpenOrderDto(orderNumber=691386666404, type=sell, rate=1729.06251226, amount=0.00057994, total=1.00275251)
OpenOrderDto(orderNumber=691385510561, type=sell, rate=1730.46350083, amount=0.00057947, total=1.00275168)
================================================================================================================================
OpenOrderDto(orderNumber=691386666404, type=sell, rate=1729.06251226, amount=0.00057994, total=1.00275251)
OpenOrderDto(orderNumber=691385510561, type=sell, rate=1730.46350083, amount=0.00057947, total=1.00275168)
================================================================================================================================
OpenOrderDto(orderNumber=691386666404, type=sell, rate=1729.06251226, amount=0.00057994, total=1.00275251)
OpenOrderDto(orderNumber=691385510561, type=sell, rate=1730.46350083, amount=0.00057947, total=1.00275168)
================================================================================================================================
OpenOrderDto(orderNumber=691386666404, type=sell, rate=1729.06251226, amount=0.00057994, total=1.00275251)
OpenOrderDto(orderNumber=691385510561, type=sell, rate=1730.46350083, amount=0.00057947, total=1.00275168)
================================================================================================================================
OpenOrderDto(orderNumber=691386666404, type=sell, rate=1729.06251226, amount=0.00057994, total=1.00275251)
OpenOrderDto(orderNumber=691385510561, type=sell, rate=1730.46350083, amount=0.00057947, total=1.00275168)
================================================================================================================================
OpenOrderDto(orderNumber=691386666404, type=sell, rate=1729.06251226, amount=0.00057994, total=1.00275251)
OpenOrderDto(orderNumber=691385510561, type=sell, rate=1730.46350083, amount=0.00057947, total=1.00275168)
================================================================================================================================
OpenOrderDto(orderNumber=691386666404, type=sell, rate=1729.06251226, amount=0.00057994, total=1.00275251)
OpenOrderDto(orderNumber=691385510561, type=sell, rate=1730.46350083, amount=0.00057947, total=1.00275168)
================================================================================================================================
OpenOrderDto(orderNumber=691386666404, type=sell, rate=1729.06251226, amount=0.00057994, total=1.00275251)
OpenOrderDto(orderNumber=691385510561, type=sell, rate=1730.46350083, amount=0.00057947, total=1.00275168)
================================================================================================================================
OpenOrderDto(orderNumber=691386666404, type=sell, rate=1729.06251226, amount=0.00057994, total=1.00275251)
OpenOrderDto(orderNumber=691385510561, type=sell, rate=1730.46350083, amount=0.00057947, total=1.00275168)
================================================================================================================================
OpenOrderDto(orderNumber=691386666404, type=sell, rate=1729.06251226, amount=0.00057994, total=1.00275251)
OpenOrderDto(orderNumber=691385510561, type=sell, rate=1730.46350083, amount=0.00057947, total=1.00275168)
================================================================================================================================
OpenOrderDto(orderNumber=691386666404, type=sell, rate=1729.06251226, amount=0.00057994, total=1.00275251)
OpenOrderDto(orderNumber=691385510561, type=sell, rate=1730.46350083, amount=0.00057947, total=1.00275168)
================================================================================================================================
OpenOrderDto(orderNumber=691386666404, type=sell, rate=1729.06251226, amount=0.00057994, total=1.00275251)
OpenOrderDto(orderNumber=691385510561, type=sell, rate=1730.46350083, amount=0.00057947, total=1.00275168)
================================================================================================================================
OpenOrderDto(orderNumber=691386666404, type=sell, rate=1729.06251226, amount=0.00057994, total=1.00275251)
OpenOrderDto(orderNumber=691385510561, type=sell, rate=1730.46350083, amount=0.00057947, total=1.00275168)
================================================================================================================================
OpenOrderDto(orderNumber=691386666404, type=sell, rate=1729.06251226, amount=0.00057994, total=1.00275251)
OpenOrderDto(orderNumber=691385510561, type=sell, rate=1730.46350083, amount=0.00057947, total=1.00275168)
================================================================================================================================
OpenOrderDto(orderNumber=691386666404, type=sell, rate=1729.06251226, amount=0.00057994, total=1.00275251)
OpenOrderDto(orderNumber=691385510561, type=sell, rate=1730.46350083, amount=0.00057947, total=1.00275168)

 */