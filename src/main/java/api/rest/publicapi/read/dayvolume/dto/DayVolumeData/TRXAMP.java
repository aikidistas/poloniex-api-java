
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TRXAMP {

    @SerializedName("AMP")
    @Expose
    public String aMP;
    @SerializedName("TRX")
    @Expose
    public String tRX;

}
