
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTSTAKE {

    @SerializedName("STAKE")
    @Expose
    public String sTAKE;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
