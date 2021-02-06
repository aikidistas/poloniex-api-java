
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTAVA {

    @SerializedName("AVA")
    @Expose
    public String aVA;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
