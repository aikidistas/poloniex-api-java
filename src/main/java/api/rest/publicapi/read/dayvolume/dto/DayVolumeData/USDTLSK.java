
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTLSK {

    @SerializedName("LSK")
    @Expose
    public String lSK;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
