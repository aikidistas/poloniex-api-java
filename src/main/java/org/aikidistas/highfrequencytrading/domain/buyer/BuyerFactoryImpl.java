package org.aikidistas.highfrequencytrading.domain.buyer;

import api.rest.privateapi.trade.buy.PoloniexBuyOrder;
import api.rest.privateapi.trade.trade.TradeOrder;

import java.math.BigDecimal;

public class BuyerFactoryImpl implements BuyerFactory {
    @Override
    public TradeOrder buy(String currencyPair, BigDecimal price, BigDecimal amount) {
        return new PoloniexBuyOrder(currencyPair, price, amount);
    }
}
