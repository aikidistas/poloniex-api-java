package api.rest.privateapi.experimental;

import api.rest.privateapi.trade.dto.OrderResultDto;

import java.util.ArrayList;

public class PoloniexTradeOrderExperimental implements TradeOrderExperimental {
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
    public PostedTradeOrderExperimental postedTradeOrder() {
        if (!this.posted) {
            throw new IllegalStateException("postedTradeOrder only can be called after trade order is posted");
        }
        return new PoloniexPostedTradeOrderExperimental(new OrderResultDto(1L, new ArrayList<>(), "")); // TODO: implement this
    }
}
