
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTMANA {

    @SerializedName("MANA")
    @Expose
    public String mANA;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
