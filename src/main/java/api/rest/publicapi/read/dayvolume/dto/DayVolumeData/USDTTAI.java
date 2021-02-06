
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTTAI {

    @SerializedName("TAI")
    @Expose
    public String tAI;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
