
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTTRADE {

    @SerializedName("TRADE")
    @Expose
    public String tRADE;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
