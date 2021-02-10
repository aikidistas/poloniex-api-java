package api.rest.privateapi.trade.trade;

import api.rest.privateapi.trade.dto.OrderResultDto;

@FunctionalInterface
public interface TradeOrder {
    OrderResultDto execute() throws Exception;
}
