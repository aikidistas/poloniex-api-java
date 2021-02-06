package api.rest.privateapi.trade.trade;

public enum TradeCommand {
    BUY("buy"),
    SELL("sell");

    private final String command;

    TradeCommand(String command) {
        this.command = command;
    }

    @Override
    public String toString() {
        return command;
    }
}
