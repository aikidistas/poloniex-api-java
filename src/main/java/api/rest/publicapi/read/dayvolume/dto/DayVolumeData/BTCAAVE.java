
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BTCAAVE {

    @SerializedName("AAVE")
    @Expose
    public String aAVE;
    @SerializedName("BTC")
    @Expose
    public String bTC;

}
