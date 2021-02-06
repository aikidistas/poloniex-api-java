
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTPLT {

    @SerializedName("PLT")
    @Expose
    public String pLT;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
