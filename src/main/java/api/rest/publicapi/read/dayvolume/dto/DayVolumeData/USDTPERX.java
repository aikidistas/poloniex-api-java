
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTPERX {

    @SerializedName("PERX")
    @Expose
    public String pERX;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
