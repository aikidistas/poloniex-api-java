
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTHEGIC {

    @SerializedName("HEGIC")
    @Expose
    public String hEGIC;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
