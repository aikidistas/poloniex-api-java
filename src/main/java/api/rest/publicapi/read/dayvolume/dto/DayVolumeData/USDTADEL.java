
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTADEL {

    @SerializedName("ADEL")
    @Expose
    public String aDEL;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
