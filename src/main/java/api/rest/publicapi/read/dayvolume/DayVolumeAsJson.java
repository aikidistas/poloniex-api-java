package api.rest.publicapi.read.dayvolume;

import api.rest.ApiException;
import api.rest.Json;
import api.rest.publicapi.PublicApiCommandResultAsJson;
import com.jcabi.aspects.RetryOnFailure;

class DayVolumeAsJson implements Json {
    private static final String COMMAND = "command=return24hVolume";
    private final Json jsonSource;

    DayVolumeAsJson() {
        this(new PublicApiCommandResultAsJson(COMMAND));
    }

    DayVolumeAsJson(Json jsonSource) {
        this.jsonSource = jsonSource;
    }

    @RetryOnFailure
    @Override
    public String json() throws ApiException {
        return jsonSource.json();
    }
}
