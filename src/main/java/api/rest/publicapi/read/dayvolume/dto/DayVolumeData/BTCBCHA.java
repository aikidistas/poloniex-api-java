
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BTCBCHA {

    @SerializedName("BCHA")
    @Expose
    public String bCHA;
    @SerializedName("BTC")
    @Expose
    public String bTC;

}
