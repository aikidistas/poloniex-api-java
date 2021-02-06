
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTCOVER {

    @SerializedName("COVER")
    @Expose
    public String cOVER;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
