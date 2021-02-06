
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TRXSWFTC {

    @SerializedName("SWFTC")
    @Expose
    public String sWFTC;
    @SerializedName("TRX")
    @Expose
    public String tRX;

}
