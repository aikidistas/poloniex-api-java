
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DAIBTC {

    @SerializedName("BTC")
    @Expose
    public String bTC;
    @SerializedName("DAI")
    @Expose
    public String dAI;

}
