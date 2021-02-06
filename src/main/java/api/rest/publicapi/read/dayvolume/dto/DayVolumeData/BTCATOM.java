
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BTCATOM {

    @SerializedName("ATOM")
    @Expose
    public String aTOM;
    @SerializedName("BTC")
    @Expose
    public String bTC;

}
