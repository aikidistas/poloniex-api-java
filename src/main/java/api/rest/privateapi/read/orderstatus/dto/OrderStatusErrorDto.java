package api.rest.privateapi.read.orderstatus.dto;

import com.google.gson.Gson;

import java.util.Map;

/**
 * @author guodong
 */
public class OrderStatusErrorDto {
    public final Integer success;
    public final Map<String, String> result;

    public OrderStatusErrorDto(Integer success, Map<String, String> result) {
        this.success = success;
        this.result = result;
    }


    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
