package api.rest.privateapi.experimental;

public class PoloniexTradeOrder implements TradeOrder {
    private boolean posted = false;

    @Override
    public void post() {
        posted = true;
    }

    @Override
    public void postSuccessfully() {

    }

    @Override
    public boolean postFailed() {
        return false;
    }

    @Override
    public boolean posted() {
        return posted;
    }

    @Override
    public PostedTradeOrder postedTradeOrder() {
        if (!this.posted) {
            throw new IllegalStateException("postedTradeOrder only can be called after trade order is posted");
        }
        return new PoloniexPostedTradeOrder();
    }
}
