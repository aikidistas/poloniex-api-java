
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BUSDBTC {

    @SerializedName("BTC")
    @Expose
    public String bTC;
    @SerializedName("BUSD")
    @Expose
    public String bUSD;

}
