
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BTCSTORJ {

    @SerializedName("BTC")
    @Expose
    public String bTC;
    @SerializedName("STORJ")
    @Expose
    public String sTORJ;

}
