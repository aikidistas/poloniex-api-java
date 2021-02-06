
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTDHT {

    @SerializedName("DHT")
    @Expose
    public String dHT;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
