
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTQTUM {

    @SerializedName("QTUM")
    @Expose
    public String qTUM;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
