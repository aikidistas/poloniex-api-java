package org.aikidistas.highfrequencytrading;

import api.rest.ApiReadException;
import api.rest.privateapi.read.completebalances.CompleteBalances;
import api.rest.privateapi.read.completebalances.CompleteBalancesData;
import api.rest.privateapi.read.completebalances.dto.CompleteBalanceDto;
import lombok.extern.log4j.Log4j2;
import org.aikidistas.utils.Sleep;

@Log4j2
public class BalancesInfoApp {
    public static void main(String... args) {
        try {
            continuouslyPrintPositiveBalances();
        } catch (ApiReadException e) {
            log.error("Failed to get data from api.", e);
        }

    }

    public static void continuouslyPrintPositiveBalances() throws ApiReadException {
        while (true) {
            printPositiveBalances();
        }
    }

    public static void printPositiveBalances() throws ApiReadException {
        System.out.println("================================================================================================================================");
        new CompleteBalancesData.Smart(new CompleteBalances())
                .positiveBalances()
                .forEach((String k, CompleteBalanceDto v) -> {
                    if (v != null) {
                        System.out.println(k + v.toString());
                    }
                });
        Sleep.seconds(3);
    }
}
