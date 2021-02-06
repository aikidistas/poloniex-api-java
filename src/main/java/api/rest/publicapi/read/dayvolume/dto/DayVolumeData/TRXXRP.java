
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TRXXRP {

    @SerializedName("TRX")
    @Expose
    public String tRX;
    @SerializedName("XRP")
    @Expose
    public String xRP;

}
