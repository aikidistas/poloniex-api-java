
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BTCCHR {

    @SerializedName("BTC")
    @Expose
    public String bTC;
    @SerializedName("CHR")
    @Expose
    public String cHR;

}
