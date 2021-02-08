package api.rest.privateapi.read.feeinfo;

import api.rest.privateapi.read.feeinfo.dto.FeeInfoDto;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import static api.rest.ApiResultPrintHelper.printAndWait;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FeeInfoTest {

    @SneakyThrows
    @Test
    public void mapPoloniexFeeInfo() {
        String data = "{\"makerFee\":\"0.00150000\",\"takerFee\":\"0.00250000\",\"thirtyDayVolume\":\"3.30872191\",\"nextTier\":\"600.00000000\"}";
        FeeInfoDto feeInfo = new FeeInfo(() -> data).data(); //mapper.mapFeeInfo(data);
        assertNotNull(feeInfo);
    }


    @SneakyThrows
    @Test
    public void data() {
        printAndWait(
                new FeeInfo().data()
        );
    }
}