package com.unsplash.sdk.client;

import com.unsplash.sdk.dto.response.PhotoResponse;
import com.unsplash.sdk.exception.ErrorResponseException;
import com.unsplash.sdk.utils.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static com.unsplash.sdk.utils.Constants.CLIENT_ID_KEY;

@Component
public class PhotoClient {

    private Helper helper = Helper.getInstance();

    @Value("${access.key}")
    private String accessKey;

    @Value("${get.photos.url}")
    private String photosUrl;

    @Autowired
    private RestTemplate restTemplate;

    public PhotoResponse[] loadPhotos() {
        ResponseEntity<String> response = restTemplate.exchange(photosUrl, HttpMethod.GET,
                helper.getHttpEntity("", CLIENT_ID_KEY, accessKey),
                String.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            return helper.jsonToObject(response.getBody(), PhotoResponse[].class);
        }
        throw new ErrorResponseException("Response not successful", response);
    }


}
