
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDCATOM {

    @SerializedName("ATOM")
    @Expose
    public String aTOM;
    @SerializedName("USDC")
    @Expose
    public String uSDC;

}
