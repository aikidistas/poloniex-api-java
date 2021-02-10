package api.wss.model;

import lombok.AllArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@ToString
public class PoloniexWSSOrderBookUpdateDto {

    public final Double currencyPair;
    public final Double orderNumber;
    public final PoloniexOrderBookEntryDto previousEntry;
    public final PoloniexWSSOrderBookUpdateDto replacementEntry;
}
