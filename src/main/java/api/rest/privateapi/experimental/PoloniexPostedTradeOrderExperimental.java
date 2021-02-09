package api.rest.privateapi.experimental;

import api.rest.privateapi.trade.dto.OrderResultDto;

class PoloniexPostedTradeOrderExperimental implements PostedTradeOrderExperimental {
    private final OrderResultDto result;

    public PoloniexPostedTradeOrderExperimental(OrderResultDto result) {
        this.result = result;
    }

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
    public ExecutedTradesExperimentalDto executedTrades() {
        return null;
    }

    @Override
    public TradeOrderExperimental moveOrder() {
        return null;
    }

    @Override
    public CancelOrderExperimental cancelOrder() {
        return null;
    }
}
