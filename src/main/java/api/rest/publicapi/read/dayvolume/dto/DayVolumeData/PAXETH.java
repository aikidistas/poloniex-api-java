
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PAXETH {

    @SerializedName("ETH")
    @Expose
    public String eTH;
    @SerializedName("PAX")
    @Expose
    public String pAX;

}
