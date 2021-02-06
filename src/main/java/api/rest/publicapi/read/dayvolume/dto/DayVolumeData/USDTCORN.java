
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTCORN {

    @SerializedName("CORN")
    @Expose
    public String cORN;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
