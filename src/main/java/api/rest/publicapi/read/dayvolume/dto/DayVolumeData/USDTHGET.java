
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTHGET {

    @SerializedName("HGET")
    @Expose
    public String hGET;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
