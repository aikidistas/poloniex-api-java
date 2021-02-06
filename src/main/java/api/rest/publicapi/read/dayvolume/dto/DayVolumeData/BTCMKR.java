
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BTCMKR {

    @SerializedName("BTC")
    @Expose
    public String bTC;
    @SerializedName("MKR")
    @Expose
    public String mKR;

}
