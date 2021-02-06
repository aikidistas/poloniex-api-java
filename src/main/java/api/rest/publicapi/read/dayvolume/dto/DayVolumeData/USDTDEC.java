
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTDEC {

    @SerializedName("DEC")
    @Expose
    public String dEC;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
