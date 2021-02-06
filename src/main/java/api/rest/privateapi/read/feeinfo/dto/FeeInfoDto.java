package api.rest.privateapi.read.feeinfo.dto;

import com.google.gson.Gson;

import java.math.BigDecimal;

/**
 * @author David
 */
public class FeeInfoDto {
    public final BigDecimal makerFee;
    public final BigDecimal takerFee;
    public final BigDecimal thirtyDayVolume;
    public final BigDecimal nextTier;

    public FeeInfoDto(BigDecimal makerFee, BigDecimal takerFee, BigDecimal thirtyDayVolume, BigDecimal nextTier) {
        this.makerFee = makerFee;
        this.takerFee = takerFee;
        this.thirtyDayVolume = thirtyDayVolume;
        this.nextTier = nextTier;
    }

    @Override
    public String toString()
    {
        return new Gson().toJson(this);
    }
}
