
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTBAND {

    @SerializedName("BAND")
    @Expose
    public String bAND;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
