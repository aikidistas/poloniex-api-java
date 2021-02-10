package api.rest.privateapi.read.ordertrades.dto;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@AllArgsConstructor
@ToString
public class OrderTradeDto {

    public final Long globalTradeID;
    public final Long tradeID;
    public final String currencyPair;
    public final String type;
    public final BigDecimal rate;
    public final BigDecimal amount;
    public final BigDecimal total;
    public final BigDecimal fee;
    public final ZonedDateTime date;
}
