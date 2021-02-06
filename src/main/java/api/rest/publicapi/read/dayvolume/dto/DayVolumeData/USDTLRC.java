
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTLRC {

    @SerializedName("LRC")
    @Expose
    public String lRC;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
