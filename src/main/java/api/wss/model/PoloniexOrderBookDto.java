package api.wss.model;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.Map;
import java.util.TreeMap;

@ToString
@AllArgsConstructor
public class PoloniexOrderBookDto {

    public final Map<String, PoloniexOrderBookEntryDto> bids;
    public final Map<String, PoloniexOrderBookEntryDto> asks;

    public PoloniexOrderBookDto() {
        this(new TreeMap<>(), new TreeMap<>());
    }
}
