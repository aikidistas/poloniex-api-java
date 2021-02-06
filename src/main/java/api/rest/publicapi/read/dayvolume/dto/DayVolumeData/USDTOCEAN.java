
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTOCEAN {

    @SerializedName("OCEAN")
    @Expose
    public String oCEAN;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
