
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTBCH {

    @SerializedName("BCH")
    @Expose
    public String bCH;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
