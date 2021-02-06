
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTLON {

    @SerializedName("LON")
    @Expose
    public String lON;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
