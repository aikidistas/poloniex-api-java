
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BTCQTUM {

    @SerializedName("BTC")
    @Expose
    public String bTC;
    @SerializedName("QTUM")
    @Expose
    public String qTUM;

}
