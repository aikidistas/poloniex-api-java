package api.rest.privateapi.experimental;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

class PoloniexExchangeExperimental implements ExchangeExperimental {
    @Override
    public TradeOrderExperimental buyOrder(String currencyPair, BigDecimal price, BigDecimal amount) {
        return new PoloniexTradeOrderExperimental();
    }

    @Override
    public TradeOrderExperimental sellOrder() {
        return new PoloniexTradeOrderExperimental();
    }

    @Override
    public List<PostedTradeOrderExperimental> postedBuyOrders() {
        return new ArrayList<>();

    }

    @Override
    public List<PostedTradeOrderExperimental> postedSellOrders() {
        return new ArrayList<>();
    }

    @Override
    public List<PostedTradeOrderExperimental> postedTradeOrders() {
        return new ArrayList<>();
    }
}
