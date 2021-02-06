
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTAMP {

    @SerializedName("AMP")
    @Expose
    public String aMP;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
