
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDCXRP {

    @SerializedName("USDC")
    @Expose
    public String uSDC;
    @SerializedName("XRP")
    @Expose
    public String xRP;

}
