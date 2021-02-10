package org.aikidistas.highfrequencytrading.domain.seller;

import api.rest.privateapi.trade.dto.OrderResultDto;
import api.rest.privateapi.trade.sell.PoloniexSellOrder;
import lombok.extern.log4j.Log4j2;

import java.math.BigDecimal;

@Log4j2
public class PoloniexSeller implements Seller {

    @Override
    public OrderResultDto sell(String currencyPair, BigDecimal price, BigDecimal amount) throws Exception {
        return new PoloniexSellOrder(currencyPair, price, amount).execute();
    }
}
