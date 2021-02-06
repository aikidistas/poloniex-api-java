
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTMKR {

    @SerializedName("MKR")
    @Expose
    public String mKR;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
