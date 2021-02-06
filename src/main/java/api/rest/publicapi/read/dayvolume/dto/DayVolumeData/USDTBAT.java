
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTBAT {

    @SerializedName("BAT")
    @Expose
    public String bAT;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
