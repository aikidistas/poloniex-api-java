
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTMTA {

    @SerializedName("MTA")
    @Expose
    public String mTA;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
