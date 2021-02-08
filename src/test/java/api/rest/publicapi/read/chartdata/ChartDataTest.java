package api.rest.publicapi.read.chartdata;

import api.rest.ApiReadException;
import api.rest.publicapi.read.chartdata.dto.ChartDataDto;
import api.rest.publicapi.read.chartdata.enums.ChartDataPeriod;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static api.rest.ApiResultPrintHelper.printAndWait;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ChartDataTest {


    @SneakyThrows
    @Test
    public void mapValidPoloniexChartData() {
        String results = "[{\"date\":1512777600,\"high\":487.0422141,\"low\":436.6987279,\"open\":441.81031703,\"close\":461.04968807,\"volume\":29389672.275876,\"quoteVolume\":63412.76665555,\"weightedAverage\":463.46617291},{\"date\":1512864000,\"high\":461.05014912,\"low\":412.0088,\"open\":461.05014912,\"close\":428.95845809,\"volume\":15297660.06622,\"quoteVolume\":35159.74815454,\"weightedAverage\":435.09014908},{\"date\":1512950400,\"high\":463.39998999,\"low\":428.95845926,\"open\":430,\"close\":461.83896992,\"volume\":8204186.3775461,\"quoteVolume\":18163.96559478,\"weightedAverage\":451.67374573}]";
        List<ChartDataDto> chartDataList = new ChartData(() -> results).chartData();

        assertEquals(3, chartDataList.size(), "There should be 3 chart data results");

        ChartDataDto chartData = chartDataList.get(0);
        assertEquals(ZonedDateTime.of(2017, 12, 9, 0, 0, 0, 0, ZoneOffset.UTC), chartData.date);
        assertEquals("487.0422141", chartData.high.toString());
        assertEquals("436.6987279", chartData.low.toString());
        assertEquals("441.81031703", chartData.open.toString());
        assertEquals("461.04968807", chartData.close.toString());
        assertEquals("29389672.275876", chartData.volume.toString());
        assertEquals("63412.76665555", chartData.quoteVolume.toString());
        assertEquals("463.46617291", chartData.weightedAverage.toString());
    }

    @SneakyThrows
    @Test
    public void mapPoloniexChartDataToTicksHandlesInvalidCurrencyPairChartDataResult() {
        String results = "{\"error\":\"Invalid currency pair.\"}";

        assertThrows(ApiReadException.class, () -> new ChartData(() -> results).chartData());
    }

    @SneakyThrows
    @Test
    public void mapPoloniexChartDataToTicksHandlesInvalidDateRangeChartDataResult() {
        String results = "[{\"date\":0,\"high\":0,\"low\":0,\"open\":0,\"close\":0,\"volume\":0,\"quoteVolume\":0,\"weightedAverage\":0}]";
        assertThrows(ApiReadException.class, () -> new ChartData(() -> results).chartData());
    }

    @SneakyThrows
    @Test
    public void mapPoloniexChartDataToTicksHandlesEmptyDateRangeChartDataResult() {
        String results = "[]";
        List<ChartDataDto> chartDataList = new ChartData(() -> results).chartData();

        assertEquals(0, chartDataList.size(), "There should be 0 chart data results");
    }

    @SneakyThrows
    @Test
    public void chartData() {
        printAndWait(new ChartData("USDT_ETH").chartData().toString());
    }

    @SneakyThrows
    @Test
    public void returnChartData() {
        List<ChartDataDto> chartDataList = new ChartData("USDT_ETH", ChartDataPeriod.HOURS_24, ZonedDateTime.of(2020, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC).toEpochSecond(), ZonedDateTime.of(2020, 1, 5, 0, 0, 0, 0, ZoneOffset.UTC).toEpochSecond()).chartData();

        chartDataList.forEach((ChartDataDto chart) -> System.out.println(chart.toString()));
        TimeUnit.SECONDS.sleep(1);
    }

}