package api.rest.publicapi.read.chartdata;

import api.rest.ApiReadException;
import api.rest.publicapi.read.chartdata.dto.ChartDataDto;

import java.util.List;

public interface ChartDataResult {
    List<ChartDataDto> chartData() throws ApiReadException;
}
