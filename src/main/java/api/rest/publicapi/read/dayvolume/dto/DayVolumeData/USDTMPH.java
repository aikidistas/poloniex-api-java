
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTMPH {

    @SerializedName("MPH")
    @Expose
    public String mPH;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
