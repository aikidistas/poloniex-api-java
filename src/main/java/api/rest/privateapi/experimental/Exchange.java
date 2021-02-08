package api.rest.privateapi.experimental;


import java.math.BigDecimal;
import java.util.List;

interface Exchange {
    TradeOrder buyOrder(String currencyPair, BigDecimal price, BigDecimal amount);

    TradeOrder sellOrder();

    List<PostedTradeOrder> postedBuyOrders();

    List<PostedTradeOrder> postedSellOrders();

    List<PostedTradeOrder> postedTradeOrders();
}
