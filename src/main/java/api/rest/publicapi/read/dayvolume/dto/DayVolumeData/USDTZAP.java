
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTZAP {

    @SerializedName("USDT")
    @Expose
    public String uSDT;
    @SerializedName("ZAP")
    @Expose
    public String zAP;

}
