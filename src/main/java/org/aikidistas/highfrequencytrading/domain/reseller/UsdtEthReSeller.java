package org.aikidistas.highfrequencytrading.domain.reseller;


import lombok.extern.log4j.Log4j2;
import org.aikidistas.highfrequencytrading.domain.buyer.Buyer;
import org.aikidistas.highfrequencytrading.domain.buyer.PoloniexBuyer;
import org.aikidistas.highfrequencytrading.domain.buyer.WaitingBuyer;
import org.aikidistas.highfrequencytrading.domain.seller.PoloniexSeller;
import org.aikidistas.highfrequencytrading.domain.seller.Seller;
import org.aikidistas.highfrequencytrading.domain.seller.WaitingSeller;
import org.cactoos.scalar.Sticky;

import java.math.BigDecimal;

@Log4j2
public class UsdtEthReSeller implements ReSeller {

    private final Buyer.Smart waitingBuyer;
    private final Seller.Smart waitingSeller;
    private final Sticky<BigDecimal> buyPrice;
    private final Sticky<BigDecimal> sellPrice;
    private final Sticky<BigDecimal> buyEthAmount;
    private final Sticky<BigDecimal> sellEthAmount;


    public UsdtEthReSeller(Sticky<BigDecimal> buyPrice, Sticky<BigDecimal> buyEthAmount, Sticky<BigDecimal> sellPrice, Sticky<BigDecimal> sellEthAmount) {
        this(
                buyPrice,
                buyEthAmount,

                sellPrice,
                sellEthAmount,

                new Buyer.Smart(new WaitingBuyer(new PoloniexBuyer())),
                new Seller.Smart(new WaitingSeller(new PoloniexSeller()))
        );
    }

    public UsdtEthReSeller(
            Sticky<BigDecimal> buyPrice,
            Sticky<BigDecimal> buyEthAmount,
            Sticky<BigDecimal> sellPrice,
            Sticky<BigDecimal> sellEthAmount,
            Buyer.Smart waitingBuyer,
            Seller.Smart waitingSeller) {

        this.buyPrice = buyPrice;
        this.buyEthAmount = buyEthAmount;

        this.sellPrice = sellPrice;
        this.sellEthAmount = sellEthAmount;

        this.waitingBuyer = waitingBuyer;
        this.waitingSeller = waitingSeller;
    }

    @Override
    public void buyAndSell() throws Exception {
        //======================================
        // BUY
        waitingBuyer.buyEthOrder(buyPrice.value(), buyEthAmount.value());
        System.out.println("==============================");
        System.out.println("BUY [" + buyEthAmount.value() + "] eth for price: " + buyPrice.value());

        //===================================================
        // SELL
        waitingSeller.sellEthOrder(sellPrice.value(), sellEthAmount.value());
        System.out.println("==============================");
        System.out.println("SELL [ " + sellEthAmount + " ] eth for price: " + sellPrice);
    }
}
