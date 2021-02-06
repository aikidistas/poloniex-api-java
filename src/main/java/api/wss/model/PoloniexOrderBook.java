package api.wss.model;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;

import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author David
 */
@AllArgsConstructor
public class PoloniexOrderBook {

    public final Map<String, PoloniexOrderBookEntry> bids;
    public final Map<String, PoloniexOrderBookEntry> asks;

    public PoloniexOrderBook() {
        this(new TreeMap<>(), new TreeMap<>());
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
