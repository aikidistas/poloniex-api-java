
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTGHST {

    @SerializedName("GHST")
    @Expose
    public String gHST;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
