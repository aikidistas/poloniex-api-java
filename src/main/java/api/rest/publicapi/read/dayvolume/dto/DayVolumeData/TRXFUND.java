
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TRXFUND {

    @SerializedName("FUND")
    @Expose
    public String fUND;
    @SerializedName("TRX")
    @Expose
    public String tRX;

}
