package org.aikidistas.highfrequencytrading;

import api.rest.ApiReadException;
import api.rest.privateapi.read.balances.Balances;
import api.rest.privateapi.read.balances.BalancesData;
import api.rest.privateapi.trade.ApiOrderException;
import api.rest.privateapi.trade.sell.PoloniexSellOrder;
import api.rest.publicapi.read.ticker.Ticker;
import api.rest.publicapi.read.ticker.dto.TickerDto;
import lombok.extern.log4j.Log4j2;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Log4j2
public class SellAllEthApp implements App {

    public static void main(String... args) {
        App app = new SellAllEthApp();
        app.run();
    }

    @Override
    public void run() {
        final BalancesData.Smart balances = new Balances.Smart(new Balances());
        final Ticker.Smart ticker = new Ticker.Smart(new Ticker());

        try {

            final BigDecimal ethBalance = balances.eth();
            final TickerDto tickerDto = ticker.usdtEthTicker();
            new PoloniexSellOrder(
                    "USDT_ETH",
                    new BigDecimal("0.00000001")
                            .add(tickerDto.highestBid).setScale(8, RoundingMode.CEILING),
                    ethBalance
            ).execute();
            log.info("sold");
        } catch (ApiReadException | ApiOrderException e) {
            log.error(e);
            System.exit(500);
        }
    }
}
// {"error":"Nonce must be greater than
// 161247743552100. You provided
// 161247742296900."}