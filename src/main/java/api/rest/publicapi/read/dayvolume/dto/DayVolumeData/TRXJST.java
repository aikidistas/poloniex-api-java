
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TRXJST {

    @SerializedName("JST")
    @Expose
    public String jST;
    @SerializedName("TRX")
    @Expose
    public String tRX;

}
