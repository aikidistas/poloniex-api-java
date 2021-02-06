
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTRSR {

    @SerializedName("RSR")
    @Expose
    public String rSR;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
