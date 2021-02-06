
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TRXSTEEM {

    @SerializedName("STEEM")
    @Expose
    public String sTEEM;
    @SerializedName("TRX")
    @Expose
    public String tRX;

}
