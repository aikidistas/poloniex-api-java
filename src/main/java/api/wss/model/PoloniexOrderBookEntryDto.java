package api.wss.model;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@AllArgsConstructor
@ToString
public class PoloniexOrderBookEntryDto {

    public final String type;
    public final BigDecimal rate;
    public final BigDecimal amount;
}
