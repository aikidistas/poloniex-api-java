
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BTCPOLY {

    @SerializedName("BTC")
    @Expose
    public String bTC;
    @SerializedName("POLY")
    @Expose
    public String pOLY;

}
