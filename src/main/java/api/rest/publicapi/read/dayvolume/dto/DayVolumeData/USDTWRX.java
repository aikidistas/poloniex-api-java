
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTWRX {

    @SerializedName("USDT")
    @Expose
    public String uSDT;
    @SerializedName("WRX")
    @Expose
    public String wRX;

}
