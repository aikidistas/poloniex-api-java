
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BTCREN {

    @SerializedName("BTC")
    @Expose
    public String bTC;
    @SerializedName("REN")
    @Expose
    public String rEN;

}
