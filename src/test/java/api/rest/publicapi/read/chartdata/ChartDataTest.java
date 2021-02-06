package api.rest.publicapi.read.chartdata;

import lombok.SneakyThrows;
import org.junit.Test;

import static api.rest.ApiResultPrintHelper.printAndWait;

public class ChartDataTest {

    @SneakyThrows
    @Test
    public void chartData() {
        printAndWait(new ChartData("USDT_ETH").chartData().toString());
    }
}