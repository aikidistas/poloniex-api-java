package api.rest.privateapi.read.orderstatus;


import api.rest.Json;
import api.rest.privateapi.read.orderstatus.dto.OrderStatusCheckDto;
import api.rest.privateapi.read.orderstatus.dto.OrderStatusDto;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class OrderStatus implements OrderStatusData {

    private final Json jsonSource;


    public OrderStatus(Long orderNumber) {
        this(new OrderStatusAsJson(orderNumber.toString()));
    }

    public OrderStatus(String orderNumber) {
        this(new OrderStatusAsJson(orderNumber));
    }

    public OrderStatus(Json jsonSource) {
        this.jsonSource = jsonSource;
    }

    @Override
    public OrderStatusDto data() throws Exception {
        try {
            String orderStatusJson = jsonSource.json();
            OrderStatusCheckDto orderStatusCheck = new Gson().fromJson(orderStatusJson, new TypeToken<OrderStatusCheckDto>() {
            }.getType());
            if (orderStatusCheck.success == 1) {    // TODO: cleanup all this different dto stuff, and error handling. On error throw exception
                return new Gson().fromJson(orderStatusJson, new TypeToken<OrderStatusDto>() {
                }.getType());
            } else {
                throw new Exception("Failed to execute OrderStatus. Api response: " + orderStatusJson);
            }

        } catch (Exception e) {
            final String message = "Error retrieving data from Api - {}";
            log.error(message, e.getMessage());
            throw new Exception(message, e);
        }
    }


}
