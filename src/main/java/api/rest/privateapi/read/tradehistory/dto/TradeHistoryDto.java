package api.rest.privateapi.read.tradehistory.dto;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@AllArgsConstructor
@ToString
public class TradeHistoryDto {
    public final Long globalTradeID;
    public final String tradeID;
    public final ZonedDateTime date;
    public final BigDecimal rate;
    public final BigDecimal amount;
    public final BigDecimal total;
    public final BigDecimal fee;
    public final String orderNumber;
    public final String type;
    public final String category;
}