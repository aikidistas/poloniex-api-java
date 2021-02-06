
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTNEO {

    @SerializedName("NEO")
    @Expose
    public String nEO;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
