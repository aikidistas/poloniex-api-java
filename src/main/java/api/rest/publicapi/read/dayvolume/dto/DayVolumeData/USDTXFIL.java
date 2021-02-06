
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTXFIL {

    @SerializedName("USDT")
    @Expose
    public String uSDT;
    @SerializedName("XFIL")
    @Expose
    public String xFIL;

}
