package api.rest;

public class ApiReadException extends ApiException {
    public ApiReadException(String e) {
        super(e);
    }

    public ApiReadException(String msg, Exception e) {
        super(msg, e);
    }


}
