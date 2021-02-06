package api.rest.privateapi.trade.sell;

import api.rest.privateapi.trade.ApiOrderException;
import api.rest.privateapi.trade.dto.OrderResultDto;

public interface SellOrder {
    OrderResultDto execute() throws ApiOrderException;
}
