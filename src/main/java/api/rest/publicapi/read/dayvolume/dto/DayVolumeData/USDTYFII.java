
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTYFII {

    @SerializedName("USDT")
    @Expose
    public String uSDT;
    @SerializedName("YFII")
    @Expose
    public String yFII;

}
