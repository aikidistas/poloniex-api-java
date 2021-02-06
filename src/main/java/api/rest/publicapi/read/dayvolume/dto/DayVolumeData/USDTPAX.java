
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTPAX {

    @SerializedName("PAX")
    @Expose
    public String pAX;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
