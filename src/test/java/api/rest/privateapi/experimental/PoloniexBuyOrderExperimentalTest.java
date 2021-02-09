package api.rest.privateapi.experimental;

import api.rest.privateapi.read.tradehistory.dto.TradeHistoryDto;
import api.rest.privateapi.trade.ApiOrderException;
import api.rest.privateapi.trade.buy.PoloniexBuyOrder;
import api.rest.privateapi.trade.dto.OrderResultDto;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PoloniexBuyOrderExperimentalTest {

    private static final List<TradeHistoryDto> RESULTING_TRADES = new ArrayList<>();
    private static final String ERROR = "";
    private final Long ORDER_NUMBER = 111111L;
    private PoloniexBuyOrderExperimental buyOrder;

    @BeforeEach
    void setUp() {
        buyOrder = new PoloniexBuyOrderExperimental(
                new PoloniexBuyOrder(() -> new OrderResultDto(ORDER_NUMBER, RESULTING_TRADES, ERROR))
        );
    }

    @Test
    void notPosted() {
        assertFalse(buyOrder.posted());
    }

    @Test
    void post() {
        buyOrder.post();
        assertTrue(buyOrder.posted());
    }

    @Test
    void postSuccessfully() {
        buyOrder.postSuccessfully();
        assertTrue(buyOrder.posted());
    }

    @SneakyThrows
    @Test
    void postFailed() {
        buyOrder = new PoloniexBuyOrderExperimental(
                new PoloniexBuyOrder(() -> {
                    throw new ApiOrderException("some error");
                })
        );
        Assertions.assertThrows(ApiOrderException.class, () -> buyOrder.post());
    }

    @Test
    void posted() {
        buyOrder.post();
        assertTrue(buyOrder.posted());
    }

    @Test
    void postedTradeOrder() {
        buyOrder.post();
        assertNotNull(buyOrder.postedTradeOrder());
    }
}