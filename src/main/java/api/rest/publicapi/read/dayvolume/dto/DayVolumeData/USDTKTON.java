
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTKTON {

    @SerializedName("KTON")
    @Expose
    public String kTON;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
