
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTBUSD {

    @SerializedName("BUSD")
    @Expose
    public String bUSD;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
