
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTCUSDT {

    @SerializedName("CUSDT")
    @Expose
    public String cUSDT;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
