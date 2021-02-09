package api.rest;

public class ApiException extends Exception {
    public ApiException(String e) {
        super(e);
    }

    public ApiException(String msg, Exception e) {
        super(msg, e);

    }
}
