package api.rest.privateapi.experimental;

interface TradeOrder {
    void post();                // try to post once, and throw exception if not success.    // final internal Status.POST_FAILED | POSTED

    void postSuccessfully();       // make sure it is posted                                   // final internal Status.POSTED

    void partiallyExecute();    //

    void execute();             // postSuccessfully() and try to wait Till execute make sure it is posted and wait till trades are executed     // final internal Status

    void executeSuccessfully();

    // TODO: think if this is result that is good? do I really need a dto? Maybe I can return interface, that specific dto is implementing?
    ExecutedTradesDto executedTrades(); // return executed trades. Empty list, if too early status. Throws exception if api failed

    ExecutedTradesDto executedTradesWithRetry(); // executedTrades() and retry if api failed

    boolean postFailed();

    boolean posted();

    boolean partiallyExecuted();

    boolean executed();

    TradeOrder moveOrder(); // TODO: check if after move you get new orderNumber, or same old (from old price). This is important if client of this interface will be able to reuse old TradeOrder object, or will only be able to use new result from this method.

    CancelOrder cancelOrder();


    enum Status { // private enum? should not be visible for interface users. So probably will be moved to interface implementation for internal usage of implementing class
        POST_FAILED,
        POSTED,
        PARTIALLY_EXECUTED,
        EXECUTED
    }
}
