
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTJFI {

    @SerializedName("JFI")
    @Expose
    public String jFI;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
