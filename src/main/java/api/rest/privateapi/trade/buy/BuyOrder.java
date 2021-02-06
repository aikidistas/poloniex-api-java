package api.rest.privateapi.trade.buy;

import api.rest.privateapi.trade.ApiOrderException;
import api.rest.privateapi.trade.dto.OrderResultDto;

public interface BuyOrder {
    OrderResultDto execute() throws ApiOrderException;

}
