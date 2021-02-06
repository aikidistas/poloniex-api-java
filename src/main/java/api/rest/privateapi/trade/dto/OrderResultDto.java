package api.rest.privateapi.trade.dto;

import api.rest.privateapi.read.tradehistory.dto.TradeHistoryDto;
import com.google.gson.Gson;

import java.util.List;

/**
 * @author David
 */
public class OrderResultDto {
    public final Long orderNumber;
    public final String error;
    public final List<TradeHistoryDto> resultingTrades;

    public OrderResultDto(Long orderNumber, List<TradeHistoryDto> resultingTrades, String error) {
        this.orderNumber = orderNumber;
        this.resultingTrades = resultingTrades;
        this.error = error;
    }

    @Override
    public String toString()
    {
        return new Gson().toJson(this);
    }
}
