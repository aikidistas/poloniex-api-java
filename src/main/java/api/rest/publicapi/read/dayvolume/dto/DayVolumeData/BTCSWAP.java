
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BTCSWAP {

    @SerializedName("BTC")
    @Expose
    public String bTC;
    @SerializedName("SWAP")
    @Expose
    public String sWAP;

}
