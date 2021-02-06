
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTETH {

    @SerializedName("ETH")
    @Expose
    public String eTH;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
