package api.rest.publicapi.read.chartdata;


import api.rest.Json;
import api.rest.publicapi.PublicApiCommandResultAsJson;
import api.rest.publicapi.read.chartdata.enums.ChartDataPeriod;

class ChartDataAsJson implements Json {
    private final Json result;

    ChartDataAsJson(String currencyPair, ChartDataPeriod period, long startTimestamp, long endTimestamp) {
        this(new PublicApiCommandResultAsJson(
                "command=returnChartData&currencyPair=" + currencyPair + "&start=" + startTimestamp + "&end=" + endTimestamp + "&period=" + period.toString()
        ));
    }


    ChartDataAsJson(Json json) {
        result = json;
    }

    @Override
    public String json() throws Exception {
        return result.json();
    }
}
