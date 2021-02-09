package api.rest.privateapi.experimental;

import api.rest.privateapi.trade.ApiOrderException;
import api.rest.privateapi.trade.buy.PoloniexBuyOrder;
import api.rest.privateapi.trade.dto.OrderResultDto;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class PoloniexBuyOrderExperimental implements TradeOrderExperimental {

    private final PoloniexBuyOrder buyOrder;

    private OrderResultDto result = null;
    private boolean posted = false;
    private boolean postFailed = false;

    public PoloniexBuyOrderExperimental(PoloniexBuyOrder buyOrder) {
        this.buyOrder = buyOrder;
    }

    @Override
    public void post() {
        try {
            result = buyOrder.execute();
            posted = true;
            postFailed = false;
        } catch (ApiOrderException e) {
            posted = false;
            postFailed = true;
            log.warn(e);
        }
    }

    @Override
    public void postSuccessfully() {
        while (!posted) {
            post();
        }
    }

    @Override
    public boolean postFailed() {
        return postFailed;
    }

    @Override
    public boolean posted() {
        return posted;
    }

    @Override
    public PostedTradeOrderExperimental postedTradeOrder() {
        return new PoloniexPostedTradeOrderExperimental(result);
    }
}
