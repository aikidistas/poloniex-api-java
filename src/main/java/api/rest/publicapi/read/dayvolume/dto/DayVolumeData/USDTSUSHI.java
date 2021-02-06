
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTSUSHI {

    @SerializedName("SUSHI")
    @Expose
    public String sUSHI;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
