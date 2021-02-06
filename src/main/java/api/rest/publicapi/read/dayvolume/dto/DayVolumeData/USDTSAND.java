
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTSAND {

    @SerializedName("SAND")
    @Expose
    public String sAND;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
