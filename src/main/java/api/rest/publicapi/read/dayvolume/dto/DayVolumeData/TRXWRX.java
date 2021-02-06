
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TRXWRX {

    @SerializedName("TRX")
    @Expose
    public String tRX;
    @SerializedName("WRX")
    @Expose
    public String wRX;

}
