package api.rest.privateapi.experimental;


interface Exchange {
    TradeOrder buyOrder();

    TradeOrder sellOrder();
}
