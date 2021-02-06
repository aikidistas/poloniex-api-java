
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTBAC {

    @SerializedName("BAC")
    @Expose
    public String bAC;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
