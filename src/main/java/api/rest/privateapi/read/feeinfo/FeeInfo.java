package api.rest.privateapi.read.feeinfo;

import api.rest.ApiReadException;
import api.rest.Json;
import api.rest.privateapi.read.feeinfo.dto.FeeInfoDto;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class FeeInfo implements FeeInfoData {
    private final Json jsonSource;


    public FeeInfo() {
        this(new FeeInfoAsJson());
    }

    public FeeInfo(Json jsonSource) {
        this.jsonSource = jsonSource;
    }

    @Override
    public FeeInfoDto data() throws ApiReadException {
        try {
            return new Gson().fromJson(
                    jsonSource.json(),
                    new TypeToken<FeeInfoDto>() {
                    }.getType()
            );
        } catch (Exception ex) {
            log.error("Error retrieving data from Api - {}", ex.getMessage());
            throw new ApiReadException(ex);
        }
    }
}
