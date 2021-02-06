package api.rest.privateapi.experimental;


import java.util.List;

interface Exchange {
    TradeOrder buyOrder();

    TradeOrder sellOrder();

    List<TradeOrder> buyOrders();

    List<TradeOrder> sellOrders();

    List<TradeOrder> tradeOrders();
}
