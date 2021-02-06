
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTDASH {

    @SerializedName("DASH")
    @Expose
    public String dASH;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
