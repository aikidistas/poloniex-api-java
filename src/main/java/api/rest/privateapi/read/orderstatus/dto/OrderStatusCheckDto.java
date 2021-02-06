package api.rest.privateapi.read.orderstatus.dto;

import com.google.gson.Gson;

/**
 * @author guodong
 */
public class OrderStatusCheckDto {
    public final Integer success;
    public final Object result;

    public OrderStatusCheckDto(Integer success, Object result) {
        this.success = success;
        this.result = result;
    }


    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
