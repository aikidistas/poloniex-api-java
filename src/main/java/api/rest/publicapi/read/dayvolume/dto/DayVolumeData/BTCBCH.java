
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BTCBCH {

    @SerializedName("BCH")
    @Expose
    public String bCH;
    @SerializedName("BTC")
    @Expose
    public String bTC;

}
