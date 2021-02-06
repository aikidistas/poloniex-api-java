
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTRFUEL {

    @SerializedName("RFUEL")
    @Expose
    public String rFUEL;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
