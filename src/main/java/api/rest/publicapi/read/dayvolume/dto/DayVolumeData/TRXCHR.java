
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TRXCHR {

    @SerializedName("CHR")
    @Expose
    public String cHR;
    @SerializedName("TRX")
    @Expose
    public String tRX;

}
