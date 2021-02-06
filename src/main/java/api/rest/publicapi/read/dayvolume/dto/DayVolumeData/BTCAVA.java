
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BTCAVA {

    @SerializedName("AVA")
    @Expose
    public String aVA;
    @SerializedName("BTC")
    @Expose
    public String bTC;

}
