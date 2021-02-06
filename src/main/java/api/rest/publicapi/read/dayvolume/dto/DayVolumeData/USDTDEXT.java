
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTDEXT {

    @SerializedName("DEXT")
    @Expose
    public String dEXT;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
