package api.rest.privateapi.read.orderstatus.dto;

import com.google.gson.Gson;

import java.util.Map;

/**
 * @author guodong
 */
public class OrderStatusDto {
    public final Integer success;
    public final String error;
    public final Map<String, OrderStatusDetailDto> result;

    public OrderStatusDto(Integer success, String error, Map<String, OrderStatusDetailDto> result) {
        this.success = success;
        this.error = error;
        this.result = result;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
