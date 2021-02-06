
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTSTR {

    @SerializedName("STR")
    @Expose
    public String sTR;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
