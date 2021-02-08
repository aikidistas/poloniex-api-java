package api.rest.privateapi.experimental;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

class PoloniexExchange implements Exchange {
    @Override
    public TradeOrder buyOrder(String currencyPair, BigDecimal price, BigDecimal amount) {
        return new PoloniexTradeOrder();
    }

    @Override
    public TradeOrder sellOrder() {
        return new PoloniexTradeOrder();
    }

    @Override
    public List<PostedTradeOrder> postedBuyOrders() {
        return new ArrayList<>();

    }

    @Override
    public List<PostedTradeOrder> postedSellOrders() {
        return new ArrayList<>();
    }

    @Override
    public List<PostedTradeOrder> postedTradeOrders() {
        return new ArrayList<>();
    }
}
