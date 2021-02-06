
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TRXBTT {

    @SerializedName("BTT")
    @Expose
    public String bTT;
    @SerializedName("TRX")
    @Expose
    public String tRX;

}
