
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTPOLS {

    @SerializedName("POLS")
    @Expose
    public String pOLS;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
