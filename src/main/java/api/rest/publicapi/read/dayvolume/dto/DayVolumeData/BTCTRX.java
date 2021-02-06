
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BTCTRX {

    @SerializedName("BTC")
    @Expose
    public String bTC;
    @SerializedName("TRX")
    @Expose
    public String tRX;

}
