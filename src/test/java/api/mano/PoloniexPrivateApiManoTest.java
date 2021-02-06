package api.mano;

import api.rest.privateapi.read.completebalances.CompleteBalances;
import api.rest.privateapi.read.completebalances.CompleteBalancesData;
import api.rest.privateapi.read.completebalances.dto.CompleteBalanceDto;
import lombok.SneakyThrows;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class PoloniexPrivateApiManoTest {

    @Before
    public void setUp() {
    }

    @SneakyThrows
    @Test
    public void returnBalances() {
        Map<String, CompleteBalanceDto> results = new CompleteBalancesData.Smart(new CompleteBalances()).positiveBalances();

        for (Map.Entry<String, CompleteBalanceDto> balance : results.entrySet()) {
            System.out.println(balance.getKey() + balance.getValue().toString());
        }
        TimeUnit.SECONDS.sleep(1);
    }
}