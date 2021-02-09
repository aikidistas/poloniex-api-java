package api.rest.privateapi.experimental;


import java.math.BigDecimal;
import java.util.List;

interface ExchangeExperimental {
    TradeOrderExperimental buyOrder(String currencyPair, BigDecimal price, BigDecimal amount);

    TradeOrderExperimental sellOrder();

    List<PostedTradeOrderExperimental> postedBuyOrders();

    List<PostedTradeOrderExperimental> postedSellOrders();

    List<PostedTradeOrderExperimental> postedTradeOrders();
}
