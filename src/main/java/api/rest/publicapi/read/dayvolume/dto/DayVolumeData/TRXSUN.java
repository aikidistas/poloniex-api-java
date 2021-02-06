
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TRXSUN {

    @SerializedName("SUN")
    @Expose
    public String sUN;
    @SerializedName("TRX")
    @Expose
    public String tRX;

}
