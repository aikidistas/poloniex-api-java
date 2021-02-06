
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTZLOT {

    @SerializedName("USDT")
    @Expose
    public String uSDT;
    @SerializedName("ZLOT")
    @Expose
    public String zLOT;

}
