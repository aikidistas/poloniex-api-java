
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTCRV {

    @SerializedName("CRV")
    @Expose
    public String cRV;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
