package api.rest.publicapi.read.dayvolume;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import static api.rest.ApiResultPrintHelper.printAndWait;

public class DayVolumeTest {

    @SneakyThrows
    @Test
    public void volume() {
        printAndWait(new DayVolume().data());
    }
}