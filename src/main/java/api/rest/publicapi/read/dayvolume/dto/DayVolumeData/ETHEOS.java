
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ETHEOS {

    @SerializedName("EOS")
    @Expose
    public String eOS;
    @SerializedName("ETH")
    @Expose
    public String eTH;

}
