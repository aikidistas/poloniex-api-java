package api.rest.publicapi.read.ticker;


import api.rest.Data;
import api.rest.publicapi.read.ticker.dto.TickerDto;

import java.util.Map;

public interface TickerData extends Data<Map<String, TickerDto>> {

    final class Smart {
        private final TickerData tickerData;

        public Smart(TickerData tickerData) {
            this.tickerData = tickerData;
        }

        public TickerDto data(String currencyPair) throws Exception {
            return tickerData.data().get(currencyPair);
        }

        public TickerDto usdtEthTicker() throws Exception {
            return data("USDT_ETH");
        }
    }
}
