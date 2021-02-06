
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BTCHGET {

    @SerializedName("BTC")
    @Expose
    public String bTC;
    @SerializedName("HGET")
    @Expose
    public String hGET;

}
