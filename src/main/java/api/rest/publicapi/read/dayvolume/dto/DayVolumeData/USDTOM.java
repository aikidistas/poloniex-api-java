
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTOM {

    @SerializedName("OM")
    @Expose
    public String oM;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
