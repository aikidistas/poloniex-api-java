
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTKP3R {

    @SerializedName("KP3R")
    @Expose
    public String kP3R;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
