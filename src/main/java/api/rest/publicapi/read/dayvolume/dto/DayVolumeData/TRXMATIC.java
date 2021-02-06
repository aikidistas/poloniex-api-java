
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TRXMATIC {

    @SerializedName("MATIC")
    @Expose
    public String mATIC;
    @SerializedName("TRX")
    @Expose
    public String tRX;

}
