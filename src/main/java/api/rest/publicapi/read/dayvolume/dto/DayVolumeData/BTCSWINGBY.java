
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BTCSWINGBY {

    @SerializedName("BTC")
    @Expose
    public String bTC;
    @SerializedName("SWINGBY")
    @Expose
    public String sWINGBY;

}
