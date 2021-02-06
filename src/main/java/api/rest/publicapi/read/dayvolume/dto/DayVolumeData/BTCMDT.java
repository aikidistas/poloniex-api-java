
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BTCMDT {

    @SerializedName("BTC")
    @Expose
    public String bTC;
    @SerializedName("MDT")
    @Expose
    public String mDT;

}
