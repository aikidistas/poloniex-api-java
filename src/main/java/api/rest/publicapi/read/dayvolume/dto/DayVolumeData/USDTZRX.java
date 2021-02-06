
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTZRX {

    @SerializedName("USDT")
    @Expose
    public String uSDT;
    @SerializedName("ZRX")
    @Expose
    public String zRX;

}
