package api.rest.privateapi.experiment2;

import org.junit.jupiter.api.Test;

public class Experiment2Test {
    @Test
    void Eth_buy__Eth_sell() {
        new Eth()
                .buy()
                .sell();
    }

    private class Eth {
        public Eth buy() {
            return this;
        }

        public Eth sell() {
            return this;
        }
    }
}
