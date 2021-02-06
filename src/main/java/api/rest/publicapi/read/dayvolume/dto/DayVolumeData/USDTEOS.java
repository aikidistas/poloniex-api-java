
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTEOS {

    @SerializedName("EOS")
    @Expose
    public String eOS;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
