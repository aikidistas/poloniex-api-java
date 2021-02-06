
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TRXWIN {

    @SerializedName("TRX")
    @Expose
    public String tRX;
    @SerializedName("WIN")
    @Expose
    public String wIN;

}
