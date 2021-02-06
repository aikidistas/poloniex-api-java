
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTBTC {

    @SerializedName("BTC")
    @Expose
    public String bTC;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
