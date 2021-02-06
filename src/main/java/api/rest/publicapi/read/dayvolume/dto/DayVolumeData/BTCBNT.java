
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BTCBNT {

    @SerializedName("BNT")
    @Expose
    public String bNT;
    @SerializedName("BTC")
    @Expose
    public String bTC;

}
