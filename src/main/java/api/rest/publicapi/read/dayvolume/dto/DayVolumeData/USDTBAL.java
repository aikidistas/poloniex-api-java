
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTBAL {

    @SerializedName("BAL")
    @Expose
    public String bAL;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
