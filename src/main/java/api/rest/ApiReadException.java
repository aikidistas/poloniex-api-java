package api.rest;

public class ApiReadException extends ApiException {
    public ApiReadException(String e) {
        super(e);
    }

    public ApiReadException(Exception e) {
        super(e);
    }
}
