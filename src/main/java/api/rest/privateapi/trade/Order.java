package api.rest.privateapi.trade;

public interface Order<Type> {
    Type execute() throws ApiOrderException;
}
