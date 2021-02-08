package api.rest.privateapi.experimental;

class PoloniexPostedTradeOrder implements PostedTradeOrder {
    @Override
    public void waitPartialTrades() {

    }

    @Override
    public void waitAllTrades() {

    }

    @Override
    public boolean partiallyTraded() {
        return false;
    }

    @Override
    public boolean fullyTraded() {
        return false;
    }

    @Override
    public ExecutedTradesDto executedTrades() {
        return null;
    }

    @Override
    public TradeOrder moveOrder() {
        return null;
    }

    @Override
    public CancelOrder cancelOrder() {
        return null;
    }
}
