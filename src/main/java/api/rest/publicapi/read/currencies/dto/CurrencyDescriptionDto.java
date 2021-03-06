package api.rest.publicapi.read.currencies.dto;

import lombok.ToString;

import java.math.BigDecimal;

@ToString
public class CurrencyDescriptionDto {
    public String blockchain;
    public String currencyType;
    public boolean delisted;
    public String depositAddress;
    public boolean disabled;
    public boolean frozen;
    public String hexColor;
    public String humanType;
    public Long id;
    public boolean isGeofenced;
    public Long minConf;
    public String name;
    public BigDecimal txFee;
}
