
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BTCSENSO {

    @SerializedName("BTC")
    @Expose
    public String bTC;
    @SerializedName("SENSO")
    @Expose
    public String sENSO;

}
