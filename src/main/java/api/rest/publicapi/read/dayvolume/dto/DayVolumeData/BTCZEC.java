
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BTCZEC {

    @SerializedName("BTC")
    @Expose
    public String bTC;
    @SerializedName("ZEC")
    @Expose
    public String zEC;

}
