package api.rest.privateapi.experimental;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ExchangeExperimentalTest {

    public static final BigDecimal PRICE = BigDecimal.ONE;
    public static final BigDecimal AMOUNT = BigDecimal.ONE;
    public static final String CURRENCY_PAIR = "USDT_ETH";
    private ExchangeExperimental exchangeExperimental;

    @BeforeEach
    void setUp() {
        exchangeExperimental = new PoloniexExchangeExperimental();
    }

    @Test
    void buyOrder() {
        String currencyPair = "USDT_ETH";
        BigDecimal price = BigDecimal.ONE;
        BigDecimal amount = BigDecimal.ONE;
        assertNotNull(exchangeExperimental.buyOrder(currencyPair, price, amount));
    }

    @Test
    void sellOrder() {
        assertNotNull(exchangeExperimental.sellOrder());
    }

    @Test
    void postedBuyOrders() {
        assertNotNull(exchangeExperimental.postedBuyOrders());
    }

    @Test
    void postedSellOrders() {
        assertNotNull(exchangeExperimental.postedSellOrders());
    }

    @Test
    void postedTradeOrders() {
        assertNotNull(exchangeExperimental.postedTradeOrders());
    }


    @Test
    void buyOrder_post() {
        TradeOrderExperimental tradeOrderExperimental = exchangeExperimental.buyOrder(CURRENCY_PAIR, PRICE, AMOUNT);
        assertFalse(tradeOrderExperimental.posted(), "tradeOrderExperimental.posted() must be false, when post() not invoked");
        tradeOrderExperimental.post();
        assertTrue(tradeOrderExperimental.posted(), "tradeOrderExperimental.posted() must be true, after post() iss invoked");
    }


    @Test
    void tradeOrder_notPosted_but_postedTradeOrder_throwsException() {
        TradeOrderExperimental tradeOrderExperimental = exchangeExperimental.buyOrder(CURRENCY_PAIR, PRICE, AMOUNT);
        Assertions.assertThrows(IllegalStateException.class, tradeOrderExperimental::postedTradeOrder);
    }

    @Test
    void buyOrder_postedTradeOrder() {
        TradeOrderExperimental tradeOrderExperimental = exchangeExperimental.buyOrder(CURRENCY_PAIR, PRICE, AMOUNT);
        tradeOrderExperimental.post();

        assertNotNull(tradeOrderExperimental.postedTradeOrder());
    }
}