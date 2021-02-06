
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTWBTC {

    @SerializedName("USDT")
    @Expose
    public String uSDT;
    @SerializedName("WBTC")
    @Expose
    public String wBTC;

}
