
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTETC {

    @SerializedName("ETC")
    @Expose
    public String eTC;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
