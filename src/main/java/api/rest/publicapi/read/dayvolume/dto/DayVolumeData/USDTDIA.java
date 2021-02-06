
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTDIA {

    @SerializedName("DIA")
    @Expose
    public String dIA;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
