package api.rest.privateapi.trade.sell;

import api.rest.privateapi.trade.ApiOrderException;
import api.rest.privateapi.trade.dto.OrderResultDto;
import api.rest.privateapi.trade.trade.PoloniexTradeOrder;
import api.rest.privateapi.trade.trade.TradeCommand;
import api.rest.privateapi.trade.trade.TradeOrder;

import java.math.BigDecimal;

public class PoloniexSellOrder implements TradeOrder {

    private final PoloniexTradeOrder tradeOrder;

    public PoloniexSellOrder(String currencyPair, BigDecimal price, BigDecimal amount) {
        this(new PoloniexTradeOrder(TradeCommand.SELL, currencyPair, price, amount));
    }

    public PoloniexSellOrder(String currencyPair, BigDecimal price, BigDecimal amount, boolean fillOrKill, boolean immediateOrCancel, boolean postOnly) {
        this(new PoloniexTradeOrder(TradeCommand.SELL, currencyPair, price, amount, fillOrKill, immediateOrCancel, postOnly));
    }

    public PoloniexSellOrder(PoloniexTradeOrder tradeOrder) {
        this.tradeOrder = tradeOrder;
    }

    @Override
    public OrderResultDto execute() throws ApiOrderException {
        return tradeOrder.execute();
    }
}
