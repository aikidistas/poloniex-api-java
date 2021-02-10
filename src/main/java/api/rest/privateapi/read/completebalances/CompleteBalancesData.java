package api.rest.privateapi.read.completebalances;

import api.rest.Data;
import api.rest.privateapi.read.completebalances.dto.CompleteBalanceDto;

import java.math.BigDecimal;
import java.util.Map;
import java.util.stream.Collectors;

public interface CompleteBalancesData extends Data<Map<String, CompleteBalanceDto>> {

    final class Smart {
        private final CompleteBalancesData dataSource;

        public Smart(CompleteBalancesData dataSource) {
            this.dataSource = dataSource;
        }

        public Map<String, CompleteBalanceDto> positiveBalances() throws Exception {
            return dataSource.data().entrySet().stream()
                    .filter(balance -> BigDecimal.ZERO.compareTo(balance.getValue().btcValue) != 0)
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        }

        public CompleteBalanceDto data(String currency) throws Exception {
            Map<String, CompleteBalanceDto> map = dataSource.data();
            if (!map.containsKey(currency)) {
                throw new Exception("Currency not found");
            }
            return dataSource.data().get(currency);
        }

        public CompleteBalanceDto usdt() throws Exception {
            return dataSource.data().get("USDT");
        }

        public CompleteBalanceDto eth() throws Exception {
            return dataSource.data().get("ETH");
        }
    }
}
