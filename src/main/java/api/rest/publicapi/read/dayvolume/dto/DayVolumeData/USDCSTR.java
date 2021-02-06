
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDCSTR {

    @SerializedName("STR")
    @Expose
    public String sTR;
    @SerializedName("USDC")
    @Expose
    public String uSDC;

}
