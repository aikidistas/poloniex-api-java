
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTFUND {

    @SerializedName("FUND")
    @Expose
    public String fUND;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
