
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BTCFOAM {

    @SerializedName("BTC")
    @Expose
    public String bTC;
    @SerializedName("FOAM")
    @Expose
    public String fOAM;

}
