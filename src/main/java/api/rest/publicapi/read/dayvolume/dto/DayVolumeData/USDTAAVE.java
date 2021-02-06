
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTAAVE {

    @SerializedName("AAVE")
    @Expose
    public String aAVE;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
