
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTTRX {

    @SerializedName("TRX")
    @Expose
    public String tRX;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
