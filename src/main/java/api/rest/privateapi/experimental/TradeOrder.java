package api.rest.privateapi.experimental;

interface TradeOrder {
    void post();                // try to post once, and throw exception if not success.    // final internal Status.POST_FAILED | POSTED

    // TODO: maybe move retryCount to implemented classes constructor? and set to default 3 retries? Then no need for this ?
    void postSuccessfully();       // make sure it is posted                                   // final internal Status.POSTED

    boolean postFailed();

    boolean posted();



    enum Status { // private enum? should not be visible for interface users. So probably will be moved to interface implementation for internal usage of implementing class
        POST_FAILED,
        POSTED
    }
}
