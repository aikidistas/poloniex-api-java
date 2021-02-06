
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ETHETC {

    @SerializedName("ETC")
    @Expose
    public String eTC;
    @SerializedName("ETH")
    @Expose
    public String eTH;

}
