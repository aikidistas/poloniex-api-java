
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BTCFARM {

    @SerializedName("BTC")
    @Expose
    public String bTC;
    @SerializedName("FARM")
    @Expose
    public String fARM;

}
