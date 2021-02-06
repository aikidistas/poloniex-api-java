
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTTRU {

    @SerializedName("TRU")
    @Expose
    public String tRU;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
