
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTFSW {

    @SerializedName("FSW")
    @Expose
    public String fSW;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
