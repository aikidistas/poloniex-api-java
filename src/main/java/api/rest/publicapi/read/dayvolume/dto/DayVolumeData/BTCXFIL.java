
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BTCXFIL {

    @SerializedName("BTC")
    @Expose
    public String bTC;
    @SerializedName("XFIL")
    @Expose
    public String xFIL;

}
