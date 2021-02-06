
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTSTEEM {

    @SerializedName("STEEM")
    @Expose
    public String sTEEM;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
