
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BTCAKRO {

    @SerializedName("AKRO")
    @Expose
    public String aKRO;
    @SerializedName("BTC")
    @Expose
    public String bTC;

}
