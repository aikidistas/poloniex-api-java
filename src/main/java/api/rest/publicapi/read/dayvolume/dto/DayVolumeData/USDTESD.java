
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTESD {

    @SerializedName("ESD")
    @Expose
    public String eSD;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
