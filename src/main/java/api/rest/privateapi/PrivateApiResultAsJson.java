package api.rest.privateapi;

import api.rest.ApiException;
import api.rest.HTTPClient;
import api.rest.Json;
import lombok.extern.log4j.Log4j2;
import org.aikidistas.configuration.Configuration;
import org.aikidistas.configuration.PoloniexApiConfiguration;
import org.apache.commons.codec.binary.Hex;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class PrivateApiResultAsJson implements Json {
    private static final String TRADING_URL = "https://poloniex.com/tradingApi?";
    private final String apiKey;
    private final String apiSecret;
    private final HTTPClient client;

    private final String command;
    private final List<NameValuePair> additionalPostParams;

    public PrivateApiResultAsJson(String command) {
        this(
                new Configuration(),
                command,
                new ArrayList<>()
        );
    }

    public PrivateApiResultAsJson(String command, List<NameValuePair> additionalPostParams) {
        this(
                new Configuration(),
                command,
                additionalPostParams
        );
    }

    public PrivateApiResultAsJson(PoloniexApiConfiguration configuration, String command, List<NameValuePair> additionalPostParams) {
        this(
                configuration.apiKey(),
                configuration.apiSecret(),
                command,
                additionalPostParams
        );
    }

    public PrivateApiResultAsJson(String apiKey, String apiSecret, String command, List<NameValuePair> additionalPostParams) {
        this(
                apiKey, apiSecret, command, additionalPostParams, new HTTPClient()
        );
    }

    public PrivateApiResultAsJson(String apiKey, String apiSecret, String command, List<NameValuePair> additionalPostParams, HTTPClient client) {
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
        this.command = command;
        this.additionalPostParams = additionalPostParams;
        this.client = client;
    }

    @Override
    public String json() throws ApiException {
        String nonceValue = String.valueOf(System.currentTimeMillis());

        try {
            List<NameValuePair> postParams = new ArrayList<>();
            postParams.add(new BasicNameValuePair("command", command));
            postParams.add(new BasicNameValuePair("nonce", nonceValue));

            if (additionalPostParams != null && additionalPostParams.size() > 0) {
                postParams.addAll(additionalPostParams);
            }

            StringBuilder sb = new StringBuilder();
            for (NameValuePair postParam : postParams) {
                if (sb.length() > 0) {
                    sb.append("&");
                }
                sb.append(postParam.getName()).append("=").append(postParam.getValue());
            }
            String body = sb.toString();

            Mac mac = Mac.getInstance("HmacSHA512");
            mac.init(new SecretKeySpec(apiSecret.getBytes(), "HmacSHA512"));
            String signature = new String(Hex.encodeHex(mac.doFinal(body.getBytes())));

            List<NameValuePair> httpHeaders = new ArrayList<>();
            httpHeaders.add(new BasicNameValuePair("Key", apiKey));
            httpHeaders.add(new BasicNameValuePair("Sign", signature));

            return client.postHttp(TRADING_URL, postParams, httpHeaders);
        } catch (IOException | NoSuchAlgorithmException | InvalidKeyException ex) {
            log.error("Call to Poloniex Private API resulted in exception - " + ex.getMessage(), ex);
            throw new ApiException(ex);
        }
    }
}
