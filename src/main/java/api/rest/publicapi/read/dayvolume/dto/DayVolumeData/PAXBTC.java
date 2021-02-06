
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PAXBTC {

    @SerializedName("BTC")
    @Expose
    public String bTC;
    @SerializedName("PAX")
    @Expose
    public String pAX;

}
