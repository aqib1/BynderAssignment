package com.unsplash.sdk.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import java.util.List;
import static com.unsplash.sdk.utils.Constants.AUTHORIZATION_KEY;

public class Helper {

    private final ObjectMapper objectMapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);


    public HttpEntity<String> getHttpEntity(String jsonBody, String placeholder, String accessToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.put(AUTHORIZATION_KEY, List.of(placeholder.concat(" ")
                .concat(accessToken)));
        return new HttpEntity(jsonBody, headers);
    }

    public HttpEntity<String> getHttpEntity(String placeholder, String accessToken) {
       return getHttpEntity(null, placeholder, accessToken);
    }


    public String asJsonString(final Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public <T> T jsonToObject(String value, Class<T> classRef) {
        try {
            return objectMapper.readValue(value, classRef);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Initialization on demand pattern
     * this pattern is alternative of double check locking pattern
     * which not even support lazy loading but also safe to use in
     * multi-processor distributed instances
     */

    private static class InstanceHolder {
        private static final Helper INSTANCE = new Helper();

        private InstanceHolder() {

        }
    }


    public static Helper getInstance() {
        return InstanceHolder.INSTANCE;
    }

    private Helper() {

    }
}
