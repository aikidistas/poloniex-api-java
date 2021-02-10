package org.aikidistas.highfrequencytrading;

import api.rest.publicapi.read.chartdata.ChartData;
import api.rest.publicapi.read.chartdata.dto.ChartDataDto;
import api.rest.publicapi.read.chartdata.enums.ChartDataPeriod;
import lombok.extern.log4j.Log4j2;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.List;

@Log4j2
public class DailyEthChartDataApp implements App {
    public static void main(String[] args) {
        App app = new DailyEthChartDataApp();
        app.run();
    }

    public void run() {
        try {
            printTodayEthChart();
        } catch (Exception e) {
            log.error("Failed to print Eth chart data for last 24 hours");
        }
    }

    private void printTodayEthChart() throws Exception {
        long yesterdayEpochSecond = ZonedDateTime.now(ZoneOffset.UTC).minusDays(1).toEpochSecond();
        long now = ZonedDateTime.now(ZoneOffset.UTC).toEpochSecond();
        List<ChartDataDto> btcDailyChartData = new ChartData("USDT_ETH", ChartDataPeriod.HOURS_24, yesterdayEpochSecond, now).chartData();
        System.out.println("==========================================================");
        btcDailyChartData
                .forEach(System.out::println);
        System.out.println("==========================================================");
    }

}
