
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BTCSTR {

    @SerializedName("BTC")
    @Expose
    public String bTC;
    @SerializedName("STR")
    @Expose
    public String sTR;

}
