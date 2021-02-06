package api.rest.privateapi.trade.move;

import api.rest.privateapi.trade.ApiOrderException;
import api.rest.privateapi.trade.dto.OrderResultDto;

public interface MoveOrder {
    OrderResultDto execute() throws ApiOrderException;
}
