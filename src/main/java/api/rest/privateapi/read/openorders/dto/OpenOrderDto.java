package api.rest.privateapi.read.openorders.dto;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@AllArgsConstructor
@ToString
public class OpenOrderDto {
    public final String orderNumber;
    public final String type;
    public final BigDecimal rate;
    public final BigDecimal amount;
    public final BigDecimal total;
}
