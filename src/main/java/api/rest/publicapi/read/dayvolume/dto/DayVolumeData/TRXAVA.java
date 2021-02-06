
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TRXAVA {

    @SerializedName("AVA")
    @Expose
    public String aVA;
    @SerializedName("TRX")
    @Expose
    public String tRX;

}
