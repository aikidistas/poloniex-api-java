package api.rest.publicapi.read.chartdata.enums;

// TODO: move this enum to ChartData api interface/class
public enum ChartDataPeriod {
    MINUTES_5(300L),
    MINUTES_15(900L),
    MINUTES_30(1_800L),
    HOURS_2(7_200L),
    HOURS_4(14_400L),
    HOURS_24(86_400L);

    private Long seconds;

    ChartDataPeriod(Long seconds) {
        this.seconds = seconds;
    }

    public Long getSeconds() {
        return seconds;
    }

    @Override
    public String toString() {
        return getSeconds().toString();
    }
}
