
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BTCKNC {

    @SerializedName("BTC")
    @Expose
    public String bTC;
    @SerializedName("KNC")
    @Expose
    public String kNC;

}
