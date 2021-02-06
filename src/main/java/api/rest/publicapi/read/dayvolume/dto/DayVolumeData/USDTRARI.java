
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTRARI {

    @SerializedName("RARI")
    @Expose
    public String rARI;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
