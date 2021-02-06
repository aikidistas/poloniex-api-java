
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTCHR {

    @SerializedName("CHR")
    @Expose
    public String cHR;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
