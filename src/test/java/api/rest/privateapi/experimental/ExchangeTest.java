package api.rest.privateapi.experimental;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ExchangeTest {

    public static final BigDecimal PRICE = BigDecimal.ONE;
    public static final BigDecimal AMOUNT = BigDecimal.ONE;
    public static final String CURRENCY_PAIR = "USDT_ETH";
    private Exchange exchange;

    @BeforeEach
    void setUp() {
        exchange = new PoloniexExchange();
    }

    @Test
    void buyOrder() {
        String currencyPair = "USDT_ETH";
        BigDecimal price = BigDecimal.ONE;
        BigDecimal amount = BigDecimal.ONE;
        assertNotNull(exchange.buyOrder(currencyPair, price, amount));
    }

    @Test
    void sellOrder() {
        assertNotNull(exchange.sellOrder());
    }

    @Test
    void postedBuyOrders() {
        assertNotNull(exchange.postedBuyOrders());
    }

    @Test
    void postedSellOrders() {
        assertNotNull(exchange.postedSellOrders());
    }

    @Test
    void postedTradeOrders() {
        assertNotNull(exchange.postedTradeOrders());
    }


    @Test
    void buyOrder_post() {
        TradeOrder tradeOrder = exchange.buyOrder(CURRENCY_PAIR, PRICE, AMOUNT);
        assertFalse(tradeOrder.posted(), "tradeOrder.posted() must be false, when post() not invoked");
        tradeOrder.post();
        assertTrue(tradeOrder.posted(), "tradeOrder.posted() must be true, after post() iss invoked");
    }


    @Test
    void tradeOrder_notPosted_but_postedTradeOrder_throwsException() {
        TradeOrder tradeOrder = exchange.buyOrder(CURRENCY_PAIR, PRICE, AMOUNT);
        Assertions.assertThrows(IllegalStateException.class, tradeOrder::postedTradeOrder);
    }

    @Test
    void buyOrder_postedTradeOrder() {
        TradeOrder tradeOrder = exchange.buyOrder(CURRENCY_PAIR, PRICE, AMOUNT);
        tradeOrder.post();

        assertNotNull(tradeOrder.postedTradeOrder());
    }
}