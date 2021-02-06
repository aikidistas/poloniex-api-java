
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTBCHA {

    @SerializedName("BCHA")
    @Expose
    public String bCHA;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
