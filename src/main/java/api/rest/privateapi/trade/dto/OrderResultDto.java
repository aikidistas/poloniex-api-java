package api.rest.privateapi.trade.dto;

import api.rest.privateapi.read.tradehistory.dto.TradeHistoryDto;
import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@ToString
public class OrderResultDto {
    public final Long orderNumber;
    public final List<TradeHistoryDto> resultingTrades;
    public final String error;
}
