
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTBAS {

    @SerializedName("BAS")
    @Expose
    public String bAS;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
