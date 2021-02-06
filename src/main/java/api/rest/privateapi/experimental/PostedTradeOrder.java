package api.rest.privateapi.experimental;

public interface PostedTradeOrder {
    void waitPartialTrades();    //

    void waitAllTrades();             // postSuccessfully() and try to wait Till execute make sure it is posted and wait till trades are executed     // final internal Status

    boolean partiallyTraded();

    boolean fullyTraded();


    // TODO: think if this is result that is good? do I really need a dto? Maybe I can return interface, that specific dto is implementing?
    ExecutedTradesDto executedTrades(); // return executed trades. Empty list, if too early status. Throws exception if api failed

    // probably delete this. Retry in smart. Or not? Look at usage, and then decide, what is more convenient
    //ExecutedTradesDto executedTradesWithRetry(); // executedTrades() and retry if api failed


    TradeOrder moveOrder(); // TODO: check if after move you get new orderNumber, or same old (from old price). This is important if client of this interface will be able to reuse old TradeOrder object, or will only be able to use new result from this method.

    CancelOrder cancelOrder();

    enum Status { // private enum? should not be visible for interface users. So probably will be moved to interface implementation for internal usage of implementing class
        PARTIALLY_EXECUTED,
        EXECUTED
    }

    final class SmartApiRetry implements PostedTradeOrder {
        private final int retryCount;
        private final PostedTradeOrder source;

        public SmartApiRetry(PostedTradeOrder source) {
            this(source, 5);
        }

        SmartApiRetry(PostedTradeOrder source, int retryCount) {
            this.source = source;
            this.retryCount = retryCount;
        }

        @Override
        public void waitPartialTrades() {
            source.waitPartialTrades();
        }

        @Override
        public void waitAllTrades() {
            source.waitAllTrades();
        }

        @Override
        public boolean partiallyTraded() {
            return source.partiallyTraded();
        }

        @Override
        public boolean fullyTraded() {
            return source.fullyTraded();
        }

        @Override
        public ExecutedTradesDto executedTrades() {
            return source.executedTrades();
        }

        @Override
        public TradeOrder moveOrder() {
            return source.moveOrder();
        }

        @Override
        public CancelOrder cancelOrder() {
            return source.cancelOrder();
        }
    }
}
