
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTMCB {

    @SerializedName("MCB")
    @Expose
    public String mCB;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
