
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BTCMATIC {

    @SerializedName("BTC")
    @Expose
    public String bTC;
    @SerializedName("MATIC")
    @Expose
    public String mATIC;

}
