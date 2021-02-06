
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BTCFCT2 {

    @SerializedName("BTC")
    @Expose
    public String bTC;
    @SerializedName("FCT2")
    @Expose
    public String fCT2;

}
