
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BTCSTPT {

    @SerializedName("BTC")
    @Expose
    public String bTC;
    @SerializedName("STPT")
    @Expose
    public String sTPT;

}
