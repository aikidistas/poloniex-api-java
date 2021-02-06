
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTBOND {

    @SerializedName("BOND")
    @Expose
    public String bOND;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
