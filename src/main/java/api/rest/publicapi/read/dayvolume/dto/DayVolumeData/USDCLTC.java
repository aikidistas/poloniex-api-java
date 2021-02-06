
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDCLTC {

    @SerializedName("LTC")
    @Expose
    public String lTC;
    @SerializedName("USDC")
    @Expose
    public String uSDC;

}
