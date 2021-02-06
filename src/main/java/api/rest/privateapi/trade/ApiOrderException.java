package api.rest.privateapi.trade;

import api.rest.ApiException;

public class ApiOrderException extends ApiException {

    public ApiOrderException(String e) {
        super(e);
    }

    public ApiOrderException(Exception e) {
        super(e);
    }
}
