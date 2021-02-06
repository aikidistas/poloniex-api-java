
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDJBTT {

    @SerializedName("BTT")
    @Expose
    public String bTT;
    @SerializedName("USDJ")
    @Expose
    public String uSDJ;

}
