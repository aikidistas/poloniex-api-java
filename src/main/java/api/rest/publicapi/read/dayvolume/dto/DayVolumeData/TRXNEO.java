
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TRXNEO {

    @SerializedName("NEO")
    @Expose
    public String nEO;
    @SerializedName("TRX")
    @Expose
    public String tRX;

}
