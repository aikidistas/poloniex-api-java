
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTPRQ {

    @SerializedName("PRQ")
    @Expose
    public String pRQ;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
