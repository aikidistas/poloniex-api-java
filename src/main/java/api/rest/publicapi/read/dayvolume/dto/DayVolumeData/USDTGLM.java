
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTGLM {

    @SerializedName("GLM")
    @Expose
    public String gLM;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
