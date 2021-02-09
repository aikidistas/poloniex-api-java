package api.rest.privateapi.read.orderstatus;

import api.rest.ApiReadException;
import api.rest.Json;
import api.rest.privateapi.read.orderstatus.dto.OrderStatusCheckDto;
import api.rest.privateapi.read.orderstatus.dto.OrderStatusDto;
import api.rest.privateapi.read.orderstatus.dto.OrderStatusErrorDto;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class OrderStatus implements OrderStatusData {

    private final Json jsonSource;

    public OrderStatus(String orderNumber) {
        this(new OrderStatusAsJson(orderNumber));
    }

    public OrderStatus(Json jsonSource) {
        this.jsonSource = jsonSource;
    }

    @Override
    public OrderStatusDto data() throws ApiReadException {
        try {


            String orderStatusJson = jsonSource.json();
            OrderStatusDto orderStatus = null;
            OrderStatusCheckDto orderStatusCheck;
            orderStatusCheck = new Gson().fromJson(orderStatusJson, new TypeToken<OrderStatusCheckDto>() {
            }.getType());
            if (orderStatusCheck.success == 1) {
                return new Gson().fromJson(orderStatusJson, new TypeToken<OrderStatusDto>() {
                }.getType());
            } else {
                OrderStatusErrorDto error = new Gson().fromJson(orderStatusJson, new TypeToken<OrderStatusErrorDto>() {
                }.getType());
                return new OrderStatusDto(0, error.result.get("error"), null);
            }

        } catch (Exception e) {
            final String message = "Error retrieving data from Api - {}";
            log.error(message, e.getMessage());
            throw new ApiReadException(message, e);
        }
    }


}
