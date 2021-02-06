
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTEXE {

    @SerializedName("EXE")
    @Expose
    public String eXE;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
