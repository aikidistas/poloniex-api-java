
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTTUSD {

    @SerializedName("TUSD")
    @Expose
    public String tUSD;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
