
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTBCHC {

    @SerializedName("BCHC")
    @Expose
    public String bCHC;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
