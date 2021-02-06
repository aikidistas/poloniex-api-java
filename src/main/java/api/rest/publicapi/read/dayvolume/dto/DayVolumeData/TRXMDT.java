
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TRXMDT {

    @SerializedName("MDT")
    @Expose
    public String mDT;
    @SerializedName("TRX")
    @Expose
    public String tRX;

}
