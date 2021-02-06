
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ETHZRX {

    @SerializedName("ETH")
    @Expose
    public String eTH;
    @SerializedName("ZRX")
    @Expose
    public String zRX;

}
