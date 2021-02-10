package api.rest.privateapi.read.completebalances.dto;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@AllArgsConstructor
@ToString
public class CompleteBalanceDto {
    public final BigDecimal available;
    public final BigDecimal onOrders;
    public final BigDecimal btcValue;
}
