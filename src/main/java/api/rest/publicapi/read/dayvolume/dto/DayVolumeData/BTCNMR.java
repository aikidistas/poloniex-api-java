
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BTCNMR {

    @SerializedName("BTC")
    @Expose
    public String bTC;
    @SerializedName("NMR")
    @Expose
    public String nMR;

}
