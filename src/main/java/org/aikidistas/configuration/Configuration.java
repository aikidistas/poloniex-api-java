package org.aikidistas.configuration;

import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Log4j2
public class Configuration implements PoloniexApiConfiguration {
    private final static String DEFAULT_PROPERTIES_FILE = "app.properties";
    private final static String POLONIEX_API_KEY_PROP_NAME = "poloniex.api.key";
    private final static String POLONIEX_API_SECRET_PROP_NAME = "poloniex.api.secret";

    private static final Properties properties;

    static {
        properties = new Properties();
        try (InputStream in = Configuration.class.getClassLoader().getResourceAsStream(DEFAULT_PROPERTIES_FILE)) {
            properties.load(in);
        } catch (IOException ex) {
            log.error("Could not load properties file " + DEFAULT_PROPERTIES_FILE + " - " + ex.getMessage());
            System.exit(500);
        }
    }

    @Override
    public String apiKey() {
        return properties.getProperty(POLONIEX_API_KEY_PROP_NAME);
    }

    @Override
    public String apiSecret() {
        return properties.getProperty(POLONIEX_API_SECRET_PROP_NAME);
    }
}
