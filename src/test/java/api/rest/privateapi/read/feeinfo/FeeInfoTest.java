package api.rest.privateapi.read.feeinfo;

import lombok.SneakyThrows;
import org.junit.Test;

import static api.rest.ApiResultPrintHelper.printAndWait;

public class FeeInfoTest {

    @SneakyThrows
    @Test
    public void data() {
        printAndWait(
                new FeeInfo().data()
        );
    }
}