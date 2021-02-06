
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTLINK {

    @SerializedName("LINK")
    @Expose
    public String lINK;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
