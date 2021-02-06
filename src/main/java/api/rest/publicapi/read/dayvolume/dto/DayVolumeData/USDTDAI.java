
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTDAI {

    @SerializedName("DAI")
    @Expose
    public String dAI;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
