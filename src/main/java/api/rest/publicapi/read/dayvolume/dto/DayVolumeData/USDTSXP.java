
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTSXP {

    @SerializedName("SXP")
    @Expose
    public String sXP;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
