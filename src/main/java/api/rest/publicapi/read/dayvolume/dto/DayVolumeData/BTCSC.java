
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BTCSC {

    @SerializedName("BTC")
    @Expose
    public String bTC;
    @SerializedName("SC")
    @Expose
    public String sC;

}
