
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTSWRV {

    @SerializedName("SWRV")
    @Expose
    public String sWRV;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
