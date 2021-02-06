package api.rest.privateapi.read.balances;

import api.rest.ApiReadException;
import api.rest.Data;

import java.math.BigDecimal;
import java.util.Map;
import java.util.stream.Collectors;

public interface BalancesData extends Data<Map<String, BigDecimal>> {

    final class Smart {
        private final BalancesData dataSource;

        public Smart(BalancesData dataSource) {
            this.dataSource = dataSource;
        }

        public Map<String, BigDecimal> positiveBalances() throws ApiReadException {
            return dataSource.data().entrySet().stream()
                    .filter(balance -> BigDecimal.ZERO.compareTo(balance.getValue()) != 0)
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        }

        public BigDecimal data(String currency) throws ApiReadException {
            Map<String, BigDecimal> map = dataSource.data();
            if (!map.containsKey(currency)) {
                throw new ApiReadException("Currency not found");
            }
            return dataSource.data().get(currency);
        }

        public BigDecimal usdt() throws ApiReadException {
            return dataSource.data().get("USDT");
        }

        public BigDecimal eth() throws ApiReadException {
            return dataSource.data().get("ETH");
        }
    }
}
