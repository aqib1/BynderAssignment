package com.unsplash.sdk.controller;

import com.unsplash.sdk.client.CollectionClient;
import com.unsplash.sdk.dto.request.AddPhotoRequest;
import com.unsplash.sdk.dto.request.CollectionRequest;
import com.unsplash.sdk.dto.response.AddPhotoToCollectionResponse;
import com.unsplash.sdk.dto.response.CollectionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import static com.unsplash.sdk.utils.Constants.ADD_PHOTO_TO_COLLECTION;
import static com.unsplash.sdk.utils.Constants.BASE_COLLECTIONS;

@RestController
@RequestMapping(BASE_COLLECTIONS)
public class CollectionsController {

    @Autowired
    private CollectionClient client;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(ADD_PHOTO_TO_COLLECTION)
    public AddPhotoToCollectionResponse addPhotoToCollection(@Valid @RequestBody AddPhotoRequest addPhotoRequest) {
        return client.addPhoto(addPhotoRequest);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public CollectionResponse create(@Valid @RequestBody CollectionRequest request) {
        return client.create(request);
    }



}
