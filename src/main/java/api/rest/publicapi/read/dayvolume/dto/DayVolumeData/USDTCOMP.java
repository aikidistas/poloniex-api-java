
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTCOMP {

    @SerializedName("COMP")
    @Expose
    public String cOMP;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
