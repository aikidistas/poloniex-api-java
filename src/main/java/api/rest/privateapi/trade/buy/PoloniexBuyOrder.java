package api.rest.privateapi.trade.buy;

import api.rest.privateapi.trade.dto.OrderResultDto;
import api.rest.privateapi.trade.trade.PoloniexTradeOrder;
import api.rest.privateapi.trade.trade.TradeCommand;
import api.rest.privateapi.trade.trade.TradeOrder;

import java.math.BigDecimal;

public class PoloniexBuyOrder implements TradeOrder {

    private final TradeOrder tradeOrder;

    public PoloniexBuyOrder(String currencyPair, BigDecimal price, BigDecimal amount) {
        this(new PoloniexTradeOrder(TradeCommand.BUY, currencyPair, price, amount));
    }

    public PoloniexBuyOrder(String currencyPair, BigDecimal price, BigDecimal amount, boolean fillOrKill, boolean immediateOrCancel, boolean postOnly) {
        this(new PoloniexTradeOrder(TradeCommand.BUY, currencyPair, price, amount, fillOrKill, immediateOrCancel, postOnly));
    }

    public PoloniexBuyOrder(TradeOrder tradeOrder) {
        this.tradeOrder = tradeOrder;
    }

    @Override
    public OrderResultDto execute() throws Exception {
        return tradeOrder.execute();
    }
}
