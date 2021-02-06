package api.wss.model;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;

/**
 * @author David
 */
@AllArgsConstructor
public class PoloniexWSSOrderBookUpdate {

    public final Double currencyPair;
    public final Double orderNumber;
    public final PoloniexOrderBookEntry previousEntry;
    public final PoloniexWSSOrderBookUpdate replacementEntry;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
