
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDCDASH {

    @SerializedName("DASH")
    @Expose
    public String dASH;
    @SerializedName("USDC")
    @Expose
    public String uSDC;

}
