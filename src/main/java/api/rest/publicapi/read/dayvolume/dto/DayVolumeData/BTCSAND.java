
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BTCSAND {

    @SerializedName("BTC")
    @Expose
    public String bTC;
    @SerializedName("SAND")
    @Expose
    public String sAND;

}
