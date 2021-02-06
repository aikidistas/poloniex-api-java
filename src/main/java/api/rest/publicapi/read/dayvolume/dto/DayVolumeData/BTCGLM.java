
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BTCGLM {

    @SerializedName("BTC")
    @Expose
    public String bTC;
    @SerializedName("GLM")
    @Expose
    public String gLM;

}
