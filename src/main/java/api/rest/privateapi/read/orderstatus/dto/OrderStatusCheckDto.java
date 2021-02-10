package api.rest.privateapi.read.orderstatus.dto;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public class OrderStatusCheckDto {
    public final Integer success;
    public final Object result;
}
