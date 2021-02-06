
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTTRB {

    @SerializedName("TRB")
    @Expose
    public String tRB;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
