
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BTCWRX {

    @SerializedName("BTC")
    @Expose
    public String bTC;
    @SerializedName("WRX")
    @Expose
    public String wRX;

}
