
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BTCREPV2 {

    @SerializedName("BTC")
    @Expose
    public String bTC;
    @SerializedName("REPV2")
    @Expose
    public String rEPV2;

}
