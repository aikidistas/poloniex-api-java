package org.aikidistas.highfrequencytrading;

import api.rest.privateapi.read.balances.Balances;
import api.rest.privateapi.trade.dto.OrderResultDto;
import api.rest.privateapi.trade.sell.PoloniexSellOrder;
import api.rest.publicapi.read.ticker.Ticker;
import lombok.extern.log4j.Log4j2;
import org.aikidistas.highfrequencytrading.domain.AtLeastMinimumOrException;
import org.aikidistas.highfrequencytrading.domain.Sum;

import java.math.BigDecimal;

@Log4j2
public class SellAllEthApp implements App {

    public static final String USDT_ETH = "USDT_ETH";
    public static final String MIN_PRICE_INCREMENT_TEXT = "0.00000001";
    public static final BigDecimal MIN_PRICE_INCREMENT = new BigDecimal(MIN_PRICE_INCREMENT_TEXT);
    public static final String MIN_TRADEABLE_AMOUNT_TEXT = "0.0001";
    public static final BigDecimal MIN_TRADEABLE_ETM_AMOUNT = new BigDecimal(MIN_TRADEABLE_AMOUNT_TEXT);


    public static void main(String... args) {
        App app = new SellAllEthApp();
        app.run();
    }

    @Override
    public void run() {
        try {
            sellAllEth();
        } catch (Exception e) {
            final String errorMessage = "Received Exception while trying to sell all eth";
            log.error(errorMessage, e);
            System.out.println("=======================================");
            System.out.println(errorMessage);
            System.out.println(e.getMessage());
        }
    }

    private void sellAllEth() throws Exception {
        final Balances.Smart balances = new Balances.Smart(new Balances());
        final Ticker.Smart ticker = new Ticker.Smart(new Ticker());
        OrderResultDto sellResult = new PoloniexSellOrder(
                USDT_ETH,
                new Sum(ticker.usdtEthTicker().highestBid, MIN_PRICE_INCREMENT).value(),
                new AtLeastMinimumOrException(
                        balances.eth(),
                        MIN_TRADEABLE_ETM_AMOUNT
                ).value()
        ).execute();
        System.out.println("=======================================");
        System.out.println("Placed Sell order for all eth. Result:");
        System.out.println(sellResult.toString());
    }
}