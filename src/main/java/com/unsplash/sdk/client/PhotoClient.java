package com.unsplash.sdk.client;

import com.unsplash.sdk.dto.request.LikePhotoRequest;
import com.unsplash.sdk.dto.request.PhotoRequest;
import com.unsplash.sdk.dto.request.RandomPhotoRequest;
import com.unsplash.sdk.dto.response.LikePhotoResponse;
import com.unsplash.sdk.dto.response.PhotoResponse;
import com.unsplash.sdk.exception.ErrorResponseException;
import com.unsplash.sdk.utils.Helper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import static com.unsplash.sdk.utils.Constants.BEARER_KEY;

@Component
public class PhotoClient {

    private static final Logger logger = LoggerFactory.getLogger(PhotoClient.class);

    private final Helper helper = Helper.getInstance();

    @Value("${get.photos.url}")
    private String photosUrl;

    @Value("${get.photos.random}")
    private String randomPhotosUrl;

    @Value("${photos.like.url}")
    private String photosLikeUrl;

    @Autowired
    private RestTemplate restTemplate;

    public PhotoResponse[] getAll(PhotoRequest request) {
        ResponseEntity<String> response = restTemplate.exchange(photosUrl, HttpMethod.GET,
                helper.getHttpEntity("", BEARER_KEY, request.getAccessToken()),
                String.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            logger.debug("Response received successfully : {}", response);
            return helper.jsonToObject(response.getBody(), PhotoResponse[].class);
        }
        throw new ErrorResponseException("Response not successful", response);
    }

    public PhotoResponse random(RandomPhotoRequest request) {
        ResponseEntity<String> response = restTemplate.exchange(randomPhotosUrl,
                HttpMethod.GET,
                helper.getHttpEntity(helper.asJsonString(request), BEARER_KEY, request.getAccessToken()),
                String.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            logger.debug("Response received successfully : {}", response);
            return helper.jsonToObject(response.getBody(), PhotoResponse.class);
        }
        throw new ErrorResponseException("Response not successful", response);
    }

    public LikePhotoResponse like(LikePhotoRequest request) {
        ResponseEntity<String> response = restTemplate.exchange(photosLikeUrl,
                HttpMethod.POST,
                helper.getHttpEntity(null, BEARER_KEY, request.getAccessToken()),
                String.class,
                request.getPhotoId());
        if (response.getStatusCode() == HttpStatus.CREATED) {
            logger.debug("Response received successfully : {}", response);
            return helper.jsonToObject(response.getBody(), LikePhotoResponse.class);
        }
        throw new ErrorResponseException("Response not successful", response);
    }
}
