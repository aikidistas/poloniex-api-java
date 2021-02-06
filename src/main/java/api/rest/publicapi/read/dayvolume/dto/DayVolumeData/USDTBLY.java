
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTBLY {

    @SerializedName("BLY")
    @Expose
    public String bLY;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
