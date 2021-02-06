
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTVALUE {

    @SerializedName("USDT")
    @Expose
    public String uSDT;
    @SerializedName("VALUE")
    @Expose
    public String vALUE;

}
