
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTREN {

    @SerializedName("REN")
    @Expose
    public String rEN;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
