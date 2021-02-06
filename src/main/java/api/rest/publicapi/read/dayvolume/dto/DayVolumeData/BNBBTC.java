
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BNBBTC {

    @SerializedName("BNB")
    @Expose
    public String bNB;
    @SerializedName("BTC")
    @Expose
    public String bTC;

}
