
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TRXDICE {

    @SerializedName("DICE")
    @Expose
    public String dICE;
    @SerializedName("TRX")
    @Expose
    public String tRX;

}
