
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTSWFTC {

    @SerializedName("SWFTC")
    @Expose
    public String sWFTC;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
