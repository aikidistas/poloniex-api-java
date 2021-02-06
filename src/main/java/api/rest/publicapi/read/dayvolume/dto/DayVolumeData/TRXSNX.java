
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TRXSNX {

    @SerializedName("SNX")
    @Expose
    public String sNX;
    @SerializedName("TRX")
    @Expose
    public String tRX;

}
