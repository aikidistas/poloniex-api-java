
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDCUSDT {

    @SerializedName("USDC")
    @Expose
    public String uSDC;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
