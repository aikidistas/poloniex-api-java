package org.aikidistas.highfrequencytrading.domain.buyer;

import api.rest.privateapi.trade.buy.PoloniexBuyOrder;
import api.rest.privateapi.trade.dto.OrderResultDto;
import lombok.extern.log4j.Log4j2;

import java.math.BigDecimal;

@Log4j2
public class PoloniexBuyer implements Buyer {

    @Override
    public OrderResultDto buy(String currencyPair, BigDecimal price, BigDecimal amount) throws Exception {
        return new PoloniexBuyOrder(currencyPair, price, amount).execute();
    }
}
