
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDCBCHSV {

    @SerializedName("BCHSV")
    @Expose
    public String bCHSV;
    @SerializedName("USDC")
    @Expose
    public String uSDC;

}
