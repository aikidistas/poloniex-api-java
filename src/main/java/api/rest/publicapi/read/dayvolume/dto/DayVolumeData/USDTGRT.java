
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTGRT {

    @SerializedName("GRT")
    @Expose
    public String gRT;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
