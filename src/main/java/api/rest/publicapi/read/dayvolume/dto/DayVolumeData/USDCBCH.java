
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDCBCH {

    @SerializedName("BCH")
    @Expose
    public String bCH;
    @SerializedName("USDC")
    @Expose
    public String uSDC;

}
