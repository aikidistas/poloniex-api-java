
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTCOMBO {

    @SerializedName("COMBO")
    @Expose
    public String cOMBO;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
