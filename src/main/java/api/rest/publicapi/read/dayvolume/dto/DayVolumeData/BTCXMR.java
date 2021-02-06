
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BTCXMR {

    @SerializedName("BTC")
    @Expose
    public String bTC;
    @SerializedName("XMR")
    @Expose
    public String xMR;

}
