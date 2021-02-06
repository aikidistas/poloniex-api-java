
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTYFI {

    @SerializedName("USDT")
    @Expose
    public String uSDT;
    @SerializedName("YFI")
    @Expose
    public String yFI;

}
