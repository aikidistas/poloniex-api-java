package api.rest.privateapi.read.orderstatus.dto;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.Map;

@AllArgsConstructor
@ToString
public class OrderStatusErrorDto {
    public final Integer success;
    public final Map<String, String> result;
}
