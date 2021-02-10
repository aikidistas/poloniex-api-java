package api.rest.privateapi.read.feeinfo.dto;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@AllArgsConstructor
@ToString
public class FeeInfoDto {
    public final BigDecimal makerFee;
    public final BigDecimal takerFee;
    public final BigDecimal thirtyDayVolume;
    public final BigDecimal nextTier;
}
