
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTXFLR {

    @SerializedName("USDT")
    @Expose
    public String uSDT;
    @SerializedName("XFLR")
    @Expose
    public String xFLR;

}
