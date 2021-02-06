
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTMATIC {

    @SerializedName("MATIC")
    @Expose
    public String mATIC;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
