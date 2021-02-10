package api.rest.publicapi.read.orderbook.dto;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.List;

// TODO: check if can make fields private
@AllArgsConstructor
@ToString
public class OrderBookDto {

    public List<List<String>> asks = null;
    public List<List<String>> bids = null;
    public String isFrozen;
    public Integer seq;
}