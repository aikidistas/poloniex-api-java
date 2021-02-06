package api.rest.publicapi.read.orderbook.dto;

import com.google.gson.Gson;

import java.util.List;

public class OrderBookDto {

    public List<List<String>> asks = null;
    public List<List<String>> bids = null;
    public String isFrozen;
    public Integer seq;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}