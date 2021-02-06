
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTXMR {

    @SerializedName("USDT")
    @Expose
    public String uSDT;
    @SerializedName("XMR")
    @Expose
    public String xMR;

}
