
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTCUDOS {

    @SerializedName("CUDOS")
    @Expose
    public String cUDOS;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
