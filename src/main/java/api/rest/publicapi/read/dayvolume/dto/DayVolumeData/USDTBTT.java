
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTBTT {

    @SerializedName("BTT")
    @Expose
    public String bTT;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
