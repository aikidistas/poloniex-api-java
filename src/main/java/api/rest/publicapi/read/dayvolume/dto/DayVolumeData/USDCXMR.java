
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDCXMR {

    @SerializedName("USDC")
    @Expose
    public String uSDC;
    @SerializedName("XMR")
    @Expose
    public String xMR;

}
