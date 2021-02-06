
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BTCLPT {

    @SerializedName("BTC")
    @Expose
    public String bTC;
    @SerializedName("LPT")
    @Expose
    public String lPT;

}
