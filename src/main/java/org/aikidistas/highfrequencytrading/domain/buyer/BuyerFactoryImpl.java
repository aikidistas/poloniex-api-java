package org.aikidistas.highfrequencytrading.domain.buyer;

import api.rest.privateapi.trade.buy.BuyOrder;
import api.rest.privateapi.trade.buy.PoloniexBuyOrder;

import java.math.BigDecimal;

public class BuyerFactoryImpl implements BuyerFactory {
    @Override
    public BuyOrder buy(String currencyPair, BigDecimal price, BigDecimal amount) {
        return new PoloniexBuyOrder(currencyPair, price, amount);
    }
}
