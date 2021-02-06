
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTUNI {

    @SerializedName("UNI")
    @Expose
    public String uNI;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
