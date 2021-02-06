
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTBVOL {

    @SerializedName("BVOL")
    @Expose
    public String bVOL;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
