
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTAKRO {

    @SerializedName("AKRO")
    @Expose
    public String aKRO;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
