
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BTCBAT {

    @SerializedName("BAT")
    @Expose
    public String bAT;
    @SerializedName("BTC")
    @Expose
    public String bTC;

}
