package org.aikidistas.highfrequencytrading;


import api.rest.privateapi.read.completebalances.CompleteBalances;
import api.rest.privateapi.read.completebalances.CompleteBalancesData;
import lombok.extern.log4j.Log4j2;
import org.aikidistas.utils.Sleep;

import java.util.Objects;

@Log4j2
public class BalancesInfoApp implements App {

    public static void main(String... args) {
        new BalancesInfoApp().run();
    }

    @Override
    public void run() {
        try {
            continuouslyPrintPositiveBalances();
        } catch (Exception e) {
            log.error("Failed to get data from api.", e);
        }
    }

    public void continuouslyPrintPositiveBalances() throws Exception {
        while (true) {
            printPositiveBalances();
        }
    }

    public void printPositiveBalances() throws Exception {
        System.out.println("================================================================================================================================");
        new CompleteBalancesData.Smart(new CompleteBalances())
                .positiveBalances().entrySet().stream()
                .filter(e -> Objects.nonNull(e.getKey()) && Objects.nonNull(e.getValue()))
                .forEach((e) -> System.out.println(e.getKey() + e.getValue().toString()));
        Sleep.seconds(3);
    }
}
