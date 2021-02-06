
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTSNX {

    @SerializedName("SNX")
    @Expose
    public String sNX;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
