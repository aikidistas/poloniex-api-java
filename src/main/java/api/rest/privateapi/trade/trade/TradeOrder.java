package api.rest.privateapi.trade.trade;

import api.rest.privateapi.trade.ApiOrderException;
import api.rest.privateapi.trade.dto.OrderResultDto;

public interface TradeOrder {
    OrderResultDto execute() throws ApiOrderException;
}