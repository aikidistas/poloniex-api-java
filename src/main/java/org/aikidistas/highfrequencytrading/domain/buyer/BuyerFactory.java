package org.aikidistas.highfrequencytrading.domain.buyer;

import api.rest.privateapi.trade.trade.TradeOrder;

import java.math.BigDecimal;

public interface BuyerFactory {
    TradeOrder buy(String currencyPair, BigDecimal price, BigDecimal amount);
}
