
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BTCLOOM {

    @SerializedName("BTC")
    @Expose
    public String bTC;
    @SerializedName("LOOM")
    @Expose
    public String lOOM;

}
