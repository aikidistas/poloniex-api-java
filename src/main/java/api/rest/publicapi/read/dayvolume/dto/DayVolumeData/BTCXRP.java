
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BTCXRP {

    @SerializedName("BTC")
    @Expose
    public String bTC;
    @SerializedName("XRP")
    @Expose
    public String xRP;

}
