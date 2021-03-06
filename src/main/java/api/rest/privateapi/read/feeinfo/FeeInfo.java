package api.rest.privateapi.read.feeinfo;

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
    public FeeInfoDto data() throws Exception {
        try {
            return new Gson().fromJson(
                    jsonSource.json(),
                    new TypeToken<FeeInfoDto>() {
                    }.getType()
            );
        } catch (Exception e) {
            final String message = "Error retrieving data from Api - {}";
            log.error(message, e.getMessage());
            throw new Exception(message, e);
        }
    }
}
