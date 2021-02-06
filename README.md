# poloniex-api-java
Java API client for the Poloniex exchange with focus on simplicity and usability. 

### User's Guide


## Websocket Interface

Using Poloniex's websocket interface is also very simple. 
The following example sets up subscriptions to the general ticker as well as the USDT_ETH order book / trades, and then runs for 60 seconds:

```java
try (WSSClient wssClient = new WSSClient(ENDPOINT_URL)) {
            wssClient.addSubscription(PoloniexWSSSubscription.USDT_ETH, new LoggerMessageHandler());
            wssClient.addSubscription(PoloniexWSSSubscription.TICKER, new TickerMessageHandler());
            wssClient.run(60000);
}
```

To setup your own subscription handler, just implement the IMessageHandler interface and do your logic within the `public void handle(String message)` method. 



