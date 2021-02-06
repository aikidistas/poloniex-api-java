
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ETHCOMP {

    @SerializedName("COMP")
    @Expose
    public String cOMP;
    @SerializedName("ETH")
    @Expose
    public String eTH;

}
