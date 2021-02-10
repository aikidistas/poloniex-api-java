package api.rest.privateapi.experiment2;

import api.rest.privateapi.read.balances.Balances;
import org.junit.jupiter.api.Test;

public class Experiment3Test {
    @Test
    void Eth_buy__Eth_sell() {
        final Usdt usdt = Usdt.from(new Balances());    // getting all balance
        final Eth eth = Eth.from(usdt); // executing a trade. and waiting for trades to happen
    }

    private static class Eth {

        public static Eth from(Usdt usdt) {
            return new Eth();
        }
    }

    private static class Usdt {

        public static Usdt from(Balances balances) {
            return new Usdt();
        }
    }
}
