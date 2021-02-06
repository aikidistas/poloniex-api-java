package api.rest;

public interface Data<Type> {
    Type data() throws ApiReadException;
}
