
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTSTPT {

    @SerializedName("STPT")
    @Expose
    public String sTPT;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
