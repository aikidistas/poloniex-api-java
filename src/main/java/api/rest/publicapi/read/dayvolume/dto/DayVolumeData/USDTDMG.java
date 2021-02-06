
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTDMG {

    @SerializedName("DMG")
    @Expose
    public String dMG;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
