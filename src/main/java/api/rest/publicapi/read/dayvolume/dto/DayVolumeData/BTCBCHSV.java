
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BTCBCHSV {

    @SerializedName("BCHSV")
    @Expose
    public String bCHSV;
    @SerializedName("BTC")
    @Expose
    public String bTC;

}
