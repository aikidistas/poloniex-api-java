
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BTCDOGE {

    @SerializedName("BTC")
    @Expose
    public String bTC;
    @SerializedName("DOGE")
    @Expose
    public String dOGE;

}
