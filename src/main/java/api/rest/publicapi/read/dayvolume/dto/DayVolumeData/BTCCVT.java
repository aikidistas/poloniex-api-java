
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BTCCVT {

    @SerializedName("BTC")
    @Expose
    public String bTC;
    @SerializedName("CVT")
    @Expose
    public String cVT;

}
