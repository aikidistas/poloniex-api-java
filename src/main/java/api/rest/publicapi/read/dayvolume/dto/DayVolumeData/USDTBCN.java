
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTBCN {

    @SerializedName("BCN")
    @Expose
    public String bCN;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
