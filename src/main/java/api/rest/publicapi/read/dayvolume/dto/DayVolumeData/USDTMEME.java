
package api.rest.publicapi.read.dayvolume.dto.DayVolumeData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class USDTMEME {

    @SerializedName("MEME")
    @Expose
    public String mEME;
    @SerializedName("USDT")
    @Expose
    public String uSDT;

}
