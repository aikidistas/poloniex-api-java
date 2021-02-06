
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTBID {

    @SerializedName("BID")
    @Expose
    public String bID;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
