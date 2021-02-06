
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BTCEOS {

    @SerializedName("BTC")
    @Expose
    public String bTC;
    @SerializedName("EOS")
    @Expose
    public String eOS;

}
