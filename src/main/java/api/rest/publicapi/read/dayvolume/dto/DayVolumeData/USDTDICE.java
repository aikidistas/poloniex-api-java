
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTDICE {

    @SerializedName("DICE")
    @Expose
    public String dICE;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
