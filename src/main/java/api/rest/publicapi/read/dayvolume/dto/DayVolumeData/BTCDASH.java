
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BTCDASH {

    @SerializedName("BTC")
    @Expose
    public String bTC;
    @SerializedName("DASH")
    @Expose
    public String dASH;

}
