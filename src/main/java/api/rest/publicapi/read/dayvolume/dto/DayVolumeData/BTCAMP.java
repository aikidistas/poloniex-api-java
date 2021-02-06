
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BTCAMP {

    @SerializedName("AMP")
    @Expose
    public String aMP;
    @SerializedName("BTC")
    @Expose
    public String bTC;

}
