
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTWIN {

    @SerializedName("USDT")
    @Expose
    public String uSDT;
    @SerializedName("WIN")
    @Expose
    public String wIN;

}
