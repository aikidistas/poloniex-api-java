
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTCVT {

    @SerializedName("CVT")
    @Expose
    public String cVT;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
