
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTJST {

    @SerializedName("JST")
    @Expose
    public String jST;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
