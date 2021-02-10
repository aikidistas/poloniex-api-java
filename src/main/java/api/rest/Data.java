package api.rest;

@FunctionalInterface
public interface Data<Type> {
    Type data() throws Exception;
}
