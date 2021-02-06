package api.wss.model;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

/**
 *
 * @author David
 */
@AllArgsConstructor
public class PoloniexOrderBookEntry {

    public final String type;
    public final BigDecimal rate;
    public final BigDecimal amount;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
