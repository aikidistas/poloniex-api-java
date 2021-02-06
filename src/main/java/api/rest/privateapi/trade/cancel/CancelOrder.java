package api.rest.privateapi.trade.cancel;

import api.rest.privateapi.trade.ApiOrderException;

public interface CancelOrder {
    boolean execute() throws ApiOrderException;
}
