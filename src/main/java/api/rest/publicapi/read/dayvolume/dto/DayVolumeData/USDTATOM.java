
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTATOM {

    @SerializedName("ATOM")
    @Expose
    public String aTOM;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
