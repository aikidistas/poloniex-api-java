package api.rest.privateapi.read.orderstatus.dto;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
class OrderStatusDetailDto {
    public final String status;
    public final String rate;
    public final String amount;
    public final String currencyPair;
    public final String date;
    public final String total;
    public final String type;
    public final String startingAmount;
}
