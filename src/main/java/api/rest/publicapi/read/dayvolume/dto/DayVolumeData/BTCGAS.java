
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BTCGAS {

    @SerializedName("BTC")
    @Expose
    public String bTC;
    @SerializedName("GAS")
    @Expose
    public String gAS;

}
