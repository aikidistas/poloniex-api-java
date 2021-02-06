
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BTCXTZ {

    @SerializedName("BTC")
    @Expose
    public String bTC;
    @SerializedName("XTZ")
    @Expose
    public String xTZ;

}
