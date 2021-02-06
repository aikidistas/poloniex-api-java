
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTXTZ {

    @SerializedName("USDT")
    @Expose
    public String uSDT;
    @SerializedName("XTZ")
    @Expose
    public String xTZ;

}
