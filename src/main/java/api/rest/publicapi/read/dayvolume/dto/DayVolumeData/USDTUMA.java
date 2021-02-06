
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTUMA {

    @SerializedName("UMA")
    @Expose
    public String uMA;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
