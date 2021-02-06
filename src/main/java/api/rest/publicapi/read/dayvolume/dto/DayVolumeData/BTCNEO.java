
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BTCNEO {

    @SerializedName("BTC")
    @Expose
    public String bTC;
    @SerializedName("NEO")
    @Expose
    public String nEO;

}
