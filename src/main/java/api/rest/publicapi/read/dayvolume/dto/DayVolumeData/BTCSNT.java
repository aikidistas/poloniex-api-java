
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BTCSNT {

    @SerializedName("BTC")
    @Expose
    public String bTC;
    @SerializedName("SNT")
    @Expose
    public String sNT;

}
