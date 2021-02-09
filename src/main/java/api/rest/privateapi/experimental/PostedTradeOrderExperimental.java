package api.rest.privateapi.experimental;

interface PostedTradeOrderExperimental {
    void waitPartialTrades();    //

    void waitAllTrades();             // postSuccessfully() and try to wait Till execute make sure it is posted and wait till trades are executed     // final internal Status

    boolean partiallyTraded();

    boolean fullyTraded();


    // TODO: think if this is result that is good? do I really need a dto? Maybe I can return interface, that specific dto is implementing?
    ExecutedTradesExperimentalDto executedTrades(); // return executed trades. Empty list, if too early status. Throws exception if api failed

    // probably delete this. Retry in smart. Or not? Look at usage, and then decide, what is more convenient
    //ExecutedTradesExperimentalDto executedTradesWithRetry(); // executedTrades() and retry if api failed


    TradeOrderExperimental moveOrder(); // TODO: check if after move you get new orderNumber, or same old (from old price). This is important if client of this interface will be able to reuse old TradeOrderExperimental object, or will only be able to use new result from this method.

    CancelOrderExperimental cancelOrder();

    enum Status { // private enum? should not be visible for interface users. So probably will be moved to interface implementation for internal usage of implementing class
        PARTIALLY_EXECUTED,
        EXECUTED
    }

    final class SmartApiRetry implements PostedTradeOrderExperimental {
        private final int retryCount;
        private final PostedTradeOrderExperimental source;

        public SmartApiRetry(PostedTradeOrderExperimental source) {
            this(source, 5);
        }

        SmartApiRetry(PostedTradeOrderExperimental source, int retryCount) {
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
        public ExecutedTradesExperimentalDto executedTrades() {
            return source.executedTrades();
        }

        @Override
        public TradeOrderExperimental moveOrder() {
            return source.moveOrder();
        }

        @Override
        public CancelOrderExperimental cancelOrder() {
            return source.cancelOrder();
        }
    }
}
