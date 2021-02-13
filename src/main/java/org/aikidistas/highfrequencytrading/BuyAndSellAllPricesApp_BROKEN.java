package org.aikidistas.highfrequencytrading;

import api.rest.publicapi.read.ticker.Ticker;
import api.rest.publicapi.read.ticker.TickerData;
import lombok.extern.log4j.Log4j2;
import org.aikidistas.highfrequencytrading.domain.buyer.Buyer;
import org.aikidistas.highfrequencytrading.domain.buyer.PoloniexBuyer;

import java.math.BigDecimal;
import java.util.stream.IntStream;

/**
 * Buy current ETH price in USDT and each 20 USDT prices below current.
 * If current price goes up whole USDT number, place an order to buy it if ReSeller for this price doesn't exist
 */
@Log4j2
public class BuyAndSellAllPricesApp_BROKEN implements App {

    public static final String USDT_ETH = "USDT_ETH";
    private final Buyer.Smart buyer = new Buyer.Smart(new PoloniexBuyer());

    public static void main(String... args) {
        App app = new BuyAndSellAllPricesApp_BROKEN();
        app.run();
    }

    @Override
    public void run() {

        try {
            continuouslyBuyAndSellMultiplePrices();
        } catch (Exception e) {
            log.error("Failed to continuously buy and sell multiple prices.", e);
        }
    }

    private void continuouslyBuyAndSellMultiplePrices() throws Exception {
        while (true) {
            BigDecimal LastPrice = new TickerData.Smart(new Ticker()).data(USDT_ETH).last;


            break;
        }


        IntStream.rangeClosed(300, 400)
                .mapToObj(BigDecimal::new)
                .forEach(price -> {
//                    final BigDecimal minEthAmount = buyer.minimumEthAmount(price);
//                    final BigDecimal total = price.multiply(minEthAmount);
//                    log.info("price: " + price + "\tminimumEthAmount:" + minEthAmount + "\ttotal: " + total);

//                    try {
//                        buyer.buyMinimumEthAmountOrder(price);
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                    Sleep.milliseconds(100);

                });
        // todo: initially execute buy orders for each 1 usdt change from 300 to 2000 usdt (if enough usdt)
        // each price is like a separate trader.
    }
}

// TODO: handle error:  2021-01-30 18:13:39,840 [main] TRACE PoloniexPrivateObjectApi - Executed and mapped USDT_ETH buy order {"error":"You may not have more than 100 open orders in a single market."} in 301 ms
