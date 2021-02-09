package org.aikidistas.highfrequencytrading;

import api.rest.ApiReadException;
import api.rest.privateapi.read.completebalances.CompleteBalances;
import api.rest.privateapi.read.completebalances.CompleteBalancesData;
import api.rest.privateapi.read.completebalances.dto.CompleteBalanceDto;
import lombok.extern.log4j.Log4j2;
import org.aikidistas.utils.Sleep;

import java.util.Map;

@Log4j2
public class BalancesInfoApp {
    public static void main(String... args) {
        while (true) {
            Map<String, CompleteBalanceDto> balances;
            try {
                balances = new CompleteBalancesData.Smart(new CompleteBalances()).positiveBalances();
            } catch (ApiReadException e) {
                continue;
            }
            if (balances != null) {
                System.out.println("================================================================================================================================");
                balances.forEach((k, v) -> {
                    if (v != null) {
                        System.out.println(k + v.toString());
                    }
                });
                Sleep.seconds(10);
            }
        }
    }
}
