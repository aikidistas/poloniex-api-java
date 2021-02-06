
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDCEOS {

    @SerializedName("EOS")
    @Expose
    public String eOS;
    @SerializedName("USDC")
    @Expose
    public String uSDC;

}
