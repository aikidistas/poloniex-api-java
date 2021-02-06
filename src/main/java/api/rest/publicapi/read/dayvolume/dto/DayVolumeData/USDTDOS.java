
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTDOS {

    @SerializedName("DOS")
    @Expose
    public String dOS;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
