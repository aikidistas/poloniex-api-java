package api.rest.privateapi.trade.cancel;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PoloniexCancelOrderTest {
    @SneakyThrows
    @Test
    public void mapCancelOrderSuccessReturnsTrue() {
        String data = "{\"success\":1}";
        boolean result = new PoloniexCancelOrder(() -> data).execute(); //mapper.mapCancelOrder(data);
        assertTrue(result);
    }

    @SneakyThrows
    @Test
    public void mapCancelOrderFailureReturnsFalse() {
        String data = "{\"success\":0}";
        boolean result = new PoloniexCancelOrder(() -> data).execute();
        assertFalse(result);
    }


}