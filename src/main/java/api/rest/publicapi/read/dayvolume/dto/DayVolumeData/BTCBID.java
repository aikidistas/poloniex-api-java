
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BTCBID {

    @SerializedName("BID")
    @Expose
    public String bID;
    @SerializedName("BTC")
    @Expose
    public String bTC;

}
