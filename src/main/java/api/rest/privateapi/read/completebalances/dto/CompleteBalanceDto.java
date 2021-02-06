package api.rest.privateapi.read.completebalances.dto;

import com.google.gson.Gson;

import java.math.BigDecimal;

/**
 * @author David
 */
public class CompleteBalanceDto {
    public final BigDecimal available;
    public final BigDecimal onOrders;
    public final BigDecimal btcValue;

    public CompleteBalanceDto(BigDecimal available, BigDecimal onOrders, BigDecimal btcValue) {
        this.available = available;
        this.onOrders = onOrders;
        this.btcValue = btcValue;
    }

    @Override
    public String toString()
    {
        return new Gson().toJson(this);
    }
}
