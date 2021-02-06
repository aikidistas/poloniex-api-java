
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BTCSTEEM {

    @SerializedName("BTC")
    @Expose
    public String bTC;
    @SerializedName("STEEM")
    @Expose
    public String sTEEM;

}
