
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTGEEQ {

    @SerializedName("GEEQ")
    @Expose
    public String gEEQ;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
