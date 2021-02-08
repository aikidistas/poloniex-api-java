package api.rest.privateapi.experimental;

interface CancelOrder {
    void execute();

    void executeSuccessfully(); // Cancelled also when order number not found.

    boolean cancelled();        // Cancelled also when order number not found.

}
