
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ETHZEC {

    @SerializedName("ETH")
    @Expose
    public String eTH;
    @SerializedName("ZEC")
    @Expose
    public String zEC;

}
