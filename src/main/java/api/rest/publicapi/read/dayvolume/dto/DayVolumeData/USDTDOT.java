
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTDOT {

    @SerializedName("DOT")
    @Expose
    public String dOT;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
