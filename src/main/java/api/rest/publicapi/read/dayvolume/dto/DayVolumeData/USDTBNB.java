
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTBNB {

    @SerializedName("BNB")
    @Expose
    public String bNB;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
