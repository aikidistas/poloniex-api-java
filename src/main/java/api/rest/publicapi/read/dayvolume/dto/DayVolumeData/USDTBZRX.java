
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTBZRX {

    @SerializedName("BZRX")
    @Expose
    public String bZRX;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
