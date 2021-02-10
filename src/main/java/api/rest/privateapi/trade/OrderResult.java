package api.rest.privateapi.trade;

public interface OrderResult<Type> {
    Type result() throws Exception;
}
