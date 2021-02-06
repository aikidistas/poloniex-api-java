
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTCVP {

    @SerializedName("CVP")
    @Expose
    public String cVP;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
