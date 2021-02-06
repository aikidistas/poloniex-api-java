
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TRXLINK {

    @SerializedName("LINK")
    @Expose
    public String lINK;
    @SerializedName("TRX")
    @Expose
    public String tRX;

}
