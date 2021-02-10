package api.rest.publicapi.read.ticker;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import static api.rest.ApiResultPrintHelper.printAndWait;

class TickerAsJsonTest {
    @SneakyThrows
    @Test
    void tickerJson() {
        printAndWait(new TickerAsJson().json());
    }
}