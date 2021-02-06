
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BTCDMG {

    @SerializedName("BTC")
    @Expose
    public String bTC;
    @SerializedName("DMG")
    @Expose
    public String dMG;

}
