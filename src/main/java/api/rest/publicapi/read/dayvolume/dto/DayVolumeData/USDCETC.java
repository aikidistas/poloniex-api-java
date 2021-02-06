
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDCETC {

    @SerializedName("ETC")
    @Expose
    public String eTC;
    @SerializedName("USDC")
    @Expose
    public String uSDC;

}
