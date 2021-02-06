
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTWNXM {

    @SerializedName("USDT")
    @Expose
    public String uSDT;
    @SerializedName("WNXM")
    @Expose
    public String wNXM;

}
