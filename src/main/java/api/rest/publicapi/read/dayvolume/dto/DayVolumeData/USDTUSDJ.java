
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTUSDJ {

    @SerializedName("USDJ")
    @Expose
    public String uSDJ;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
