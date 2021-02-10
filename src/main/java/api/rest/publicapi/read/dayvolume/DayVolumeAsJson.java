package api.rest.publicapi.read.dayvolume;


import api.rest.Json;
import api.rest.publicapi.PublicApiCommandResultAsJson;

class DayVolumeAsJson implements Json {
    private static final String COMMAND = "command=return24hVolume";
    private final Json jsonSource;

    DayVolumeAsJson() {
        this(new PublicApiCommandResultAsJson(COMMAND));
    }

    DayVolumeAsJson(Json jsonSource) {
        this.jsonSource = jsonSource;
    }

    @Override
    public String json() throws Exception {
        return jsonSource.json();
    }
}
