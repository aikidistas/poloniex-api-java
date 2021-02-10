package org.aikidistas.highfrequencytrading.domain.seller;

import api.rest.privateapi.trade.dto.OrderResultDto;
import lombok.SneakyThrows;
import org.aikidistas.highfrequencytrading.domain.Multiplication;
import org.cactoos.Scalar;

import java.math.BigDecimal;
import java.math.RoundingMode;

public interface Seller {
    OrderResultDto sell(String currencyPair, BigDecimal price, BigDecimal amount) throws Exception;

    final class Smart {
        private static final BigDecimal MIN_ETH_AMOUNT = new BigDecimal("0.0001");
        private static final BigDecimal MIN_USDT_AMOUNT = BigDecimal.ONE;

        private final Seller seller;

        public Smart(Seller seller) {
            this.seller = seller;
        }

        public OrderResultDto sellEthOrder(Scalar<BigDecimal> price, Scalar<BigDecimal> amount) throws Exception {
            return seller.sell("USDT_ETH", price.value(), amount.value());
        }

        public OrderResultDto sellEthOrder(BigDecimal price, BigDecimal amount) throws Exception {
            return seller.sell("USDT_ETH", price, amount);
        }

        public OrderResultDto sellMinimumEthAmountOrder(BigDecimal price) throws Exception {
            return sellEthOrder(price, minimumEthAmount(price));
        }

        @SneakyThrows
        public BigDecimal minimumEthAmount(BigDecimal price) {
            BigDecimal ethAmount = MIN_ETH_AMOUNT;
            BigDecimal totalUsdt = new Multiplication(price, ethAmount).value();
            if (totalUsdt.compareTo(MIN_USDT_AMOUNT) < 0) {
                ethAmount = MIN_USDT_AMOUNT
                        .divide(price, 8, RoundingMode.CEILING) // amount for 1 usdt
                        .setScale(8, RoundingMode.CEILING);
            }
            return ethAmount;
        }
    }
}
