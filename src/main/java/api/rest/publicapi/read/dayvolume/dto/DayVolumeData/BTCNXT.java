
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BTCNXT {

    @SerializedName("BTC")
    @Expose
    public String bTC;
    @SerializedName("NXT")
    @Expose
    public String nXT;

}
