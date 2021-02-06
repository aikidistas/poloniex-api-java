
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDCETH {

    @SerializedName("ETH")
    @Expose
    public String eTH;
    @SerializedName("USDC")
    @Expose
    public String uSDC;

}
