
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TRXSXP {

    @SerializedName("SXP")
    @Expose
    public String sXP;
    @SerializedName("TRX")
    @Expose
    public String tRX;

}
