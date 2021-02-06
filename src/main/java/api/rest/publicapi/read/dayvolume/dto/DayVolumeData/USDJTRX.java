
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDJTRX {

    @SerializedName("TRX")
    @Expose
    public String tRX;
    @SerializedName("USDJ")
    @Expose
    public String uSDJ;

}
