
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BTCINJ {

    @SerializedName("BTC")
    @Expose
    public String bTC;
    @SerializedName("INJ")
    @Expose
    public String iNJ;

}
