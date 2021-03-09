package com.unsplash.sdk.client;

import com.unsplash.sdk.dto.request.AddPhotoRequest;
import com.unsplash.sdk.dto.request.CollectionRequest;
import com.unsplash.sdk.dto.response.AddPhotoResponse;
import com.unsplash.sdk.dto.response.CollectionResponse;
import com.unsplash.sdk.exception.ErrorResponseException;
import com.unsplash.sdk.utils.Helper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import static com.unsplash.sdk.utils.Constants.BEARER_KEY;

@Component
public class CollectionClient {

    private static final Logger logger = LoggerFactory.getLogger(CollectionClient.class);

    private final Helper helper = Helper.getInstance();

    @Value("${create.collection.url}")
    private String collectionUrl;

    @Value("${add.photo.url}")
    private String addPhotoInCollectionUrl;

    @Autowired
    private RestTemplate restTemplate;

    public CollectionResponse create(CollectionRequest request) {
        ResponseEntity<String> response = restTemplate.postForEntity(collectionUrl, helper.getHttpEntity(helper.asJsonString(request), BEARER_KEY, request.getAccessToken()), String.class);
        if (response.getStatusCode() == HttpStatus.CREATED) {
            logger.debug("Response received successfully : {}", response);
            return helper.jsonToObject(response.getBody(), CollectionResponse.class);
        }
        throw new ErrorResponseException("Response not successful", response);
    }

    public AddPhotoResponse addPhotoToCollection(AddPhotoRequest request) {
        ResponseEntity<String> response = restTemplate.postForEntity(addPhotoInCollectionUrl,
                helper.getHttpEntity(helper.asJsonString(request), BEARER_KEY, request.getAccessToken()),
                String.class,
                request.getCollectionId());
        if (response.getStatusCode() == HttpStatus.CREATED) {
            logger.debug("Response received successfully : {}", response);
            return helper.jsonToObject(response.getBody(), AddPhotoResponse.class);
        }
        throw new ErrorResponseException("Response not successful", response);
    }
}
