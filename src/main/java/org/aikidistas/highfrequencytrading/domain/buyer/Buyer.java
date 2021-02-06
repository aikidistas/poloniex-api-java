package org.aikidistas.highfrequencytrading.domain.buyer;

import api.rest.privateapi.trade.ApiOrderException;
import api.rest.privateapi.trade.dto.OrderResultDto;

import java.math.BigDecimal;
import java.math.RoundingMode;

public interface Buyer {
    OrderResultDto buy(String currencyPair, BigDecimal price, BigDecimal amount) throws ApiOrderException;

    final class Smart {
        private static final BigDecimal MIN_ETH_AMOUNT = new BigDecimal("0.0001");
        private static final BigDecimal MIN_USDT_AMOUNT = BigDecimal.ONE;

        private final Buyer buyer;

        public Smart(Buyer buyer) {
            this.buyer = buyer;
        }

        public OrderResultDto buyEthOrder(BigDecimal price, BigDecimal amount) throws ApiOrderException {
            return buyer.buy("USDT_ETH", price, amount);
        }

        public OrderResultDto buyMinimumEthAmountOrder(BigDecimal price) throws ApiOrderException {
            return buyEthOrder(price, minimumEthAmount(price));
        }

        public BigDecimal minimumEthAmount(BigDecimal price) {
            BigDecimal buyEthAmount = MIN_ETH_AMOUNT;
            BigDecimal totalUsdt = price.multiply(buyEthAmount);
            if (totalUsdt.compareTo(MIN_USDT_AMOUNT) < 0) {
                buyEthAmount = MIN_USDT_AMOUNT
                        .divide(price, 8, RoundingMode.CEILING) // amount for 1 usdt
//                        .multiply(new BigDecimal("1.00125")) // amount for fee
                        .setScale(8, RoundingMode.CEILING);
            }
            return buyEthAmount;
        }
    }
}
