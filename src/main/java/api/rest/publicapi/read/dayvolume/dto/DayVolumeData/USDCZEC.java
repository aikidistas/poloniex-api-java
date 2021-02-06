
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDCZEC {

    @SerializedName("USDC")
    @Expose
    public String uSDC;
    @SerializedName("ZEC")
    @Expose
    public String zEC;

}
