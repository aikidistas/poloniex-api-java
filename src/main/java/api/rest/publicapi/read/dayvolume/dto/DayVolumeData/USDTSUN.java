
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTSUN {

    @SerializedName("SUN")
    @Expose
    public String sUN;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
