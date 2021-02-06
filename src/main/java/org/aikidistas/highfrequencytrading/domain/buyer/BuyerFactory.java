package org.aikidistas.highfrequencytrading.domain.buyer;

import api.rest.privateapi.trade.buy.BuyOrder;

import java.math.BigDecimal;

public interface BuyerFactory {
    BuyOrder buy(String currencyPair, BigDecimal price, BigDecimal amount);
}
