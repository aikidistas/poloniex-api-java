package api.rest.privateapi.read.orderstatus.dto;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.Map;

@AllArgsConstructor
@ToString
public class OrderStatusDto {
    public final Integer success;
    public final String error;
    public final Map<String, OrderStatusDetailDto> result;
}
