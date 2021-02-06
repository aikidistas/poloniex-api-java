
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDCTRX {

    @SerializedName("TRX")
    @Expose
    public String tRX;
    @SerializedName("USDC")
    @Expose
    public String uSDC;

}
