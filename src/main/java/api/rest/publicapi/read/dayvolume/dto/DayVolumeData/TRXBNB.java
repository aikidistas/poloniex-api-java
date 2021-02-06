
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TRXBNB {

    @SerializedName("BNB")
    @Expose
    public String bNB;
    @SerializedName("TRX")
    @Expose
    public String tRX;

}
