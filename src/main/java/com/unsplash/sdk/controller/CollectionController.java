package com.unsplash.sdk.controller;

import com.unsplash.sdk.client.CollectionClient;
import com.unsplash.sdk.dto.request.AddPhotoRequest;
import com.unsplash.sdk.dto.request.CollectionRequest;
import com.unsplash.sdk.dto.response.AddPhotoResponse;
import com.unsplash.sdk.dto.response.CollectionResponse;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.unsplash.sdk.utils.Constants.ADD_PHOTO_TO_COLLECTION;
import static com.unsplash.sdk.utils.Constants.BASE_COLLECTIONS;

@RestController
@RequestMapping(BASE_COLLECTIONS)
public class CollectionController {

    private static final Logger logger = LoggerFactory.getLogger(CollectionController.class);

    @Autowired
    private CollectionClient client;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(ADD_PHOTO_TO_COLLECTION)
    @ApiOperation(value = "Add photo to collection", response = AddPhotoResponse.class)
    public AddPhotoResponse addPhotoToCollection(@Valid @RequestBody AddPhotoRequest addPhotoRequest) {
        logger.debug("Request received : {}", addPhotoRequest);
        return client.addPhotoToCollection(addPhotoRequest);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @ApiOperation(value = "Create a new collection", response = CollectionResponse.class)
    public CollectionResponse create(@Valid @RequestBody CollectionRequest request) {
        logger.debug("Request received : {}", request);
        return client.create(request);
    }

}
