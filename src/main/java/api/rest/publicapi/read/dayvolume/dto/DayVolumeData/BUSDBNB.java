
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BUSDBNB {

    @SerializedName("BNB")
    @Expose
    public String bNB;
    @SerializedName("BUSD")
    @Expose
    public String bUSD;

}
