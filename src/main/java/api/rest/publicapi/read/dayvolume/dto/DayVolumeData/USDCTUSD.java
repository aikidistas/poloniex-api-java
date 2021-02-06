
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDCTUSD {

    @SerializedName("TUSD")
    @Expose
    public String tUSD;
    @SerializedName("USDC")
    @Expose
    public String uSDC;

}
