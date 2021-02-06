
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTLTC {

    @SerializedName("LTC")
    @Expose
    public String lTC;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
