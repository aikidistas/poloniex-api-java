package org.aikidistas.highfrequencytrading;


import api.rest.publicapi.read.ticker.Ticker;
import lombok.extern.log4j.Log4j2;
import org.aikidistas.highfrequencytrading.domain.Multiplication;
import org.aikidistas.highfrequencytrading.domain.Sum;
import org.aikidistas.highfrequencytrading.domain.buyer.Buyer;
import org.aikidistas.highfrequencytrading.domain.buyer.PoloniexBuyer;
import org.aikidistas.highfrequencytrading.domain.reseller.ReSeller;
import org.aikidistas.highfrequencytrading.domain.reseller.UsdtEthReSeller;
import org.cactoos.scalar.Sticky;

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
    private final Buyer.Smart buyer = new Buyer.Smart(new PoloniexBuyer());

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

        Sticky<BigDecimal> buyPrice = buyPrice();

        Sticky<BigDecimal> buyAmount = buyAmount(buyPrice);

        Sticky<BigDecimal> sellPrice = sellPrice(buyPrice);

        Sticky<BigDecimal> sellAmount = sellAmount(buyAmount);

        ReSeller reSeller = new UsdtEthReSeller(
                buyPrice,
                buyAmount,
                sellPrice,
                sellAmount
        );

        reSeller.buyAndSell();
    }

    private Sticky<BigDecimal> sellAmount(Sticky<BigDecimal> buyAmount) {
        return new Sticky<>(new Multiplication(
                buyAmount,
                () -> new BigDecimal("0.99875")
        ));
    }

    private Sticky<BigDecimal> sellPrice(Sticky<BigDecimal> buyPrice) {
        return new Sticky<>(new Multiplication(
                buyPrice,
                () -> new BigDecimal("1.004")
        ));
    }

    private Sticky<BigDecimal> buyAmount(Sticky<BigDecimal> buyPrice) {
        return new Sticky<>(() -> buyer.minimumEthAmount(buyPrice.value()));
    }

    private Sticky<BigDecimal> buyPrice() throws Exception {
        return new Sticky<>(new Sum(
                new Ticker.Smart(new Ticker()).usdtEthTicker().highestBid,
                MINIMUM_NUMBER_INCREMENT
        ));
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