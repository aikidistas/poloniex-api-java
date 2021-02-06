
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTNU {

    @SerializedName("NU")
    @Expose
    public String nU;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
