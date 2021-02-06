
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TRXDMG {

    @SerializedName("DMG")
    @Expose
    public String dMG;
    @SerializedName("TRX")
    @Expose
    public String tRX;

}
