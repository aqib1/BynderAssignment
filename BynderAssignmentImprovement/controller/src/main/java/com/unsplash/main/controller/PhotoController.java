package com.unsplash.main.controller;

import com.unsplash.domain.request.LikePhotoRequest;
import com.unsplash.domain.request.PhotoRequest;
import com.unsplash.domain.request.RandomPhotoRequest;
import com.unsplash.domain.response.LikePhotoResponse;
import com.unsplash.domain.response.PhotoResponse;
import com.unsplash.service.client.PhotoClient;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import static com.unsplash.utilities.Constants.*;


@RestController
@RequestMapping(BASE_PHOTOS)
public class PhotoController {

    private static final Logger logger = LoggerFactory.getLogger(PhotoController.class);

    @Autowired
    private PhotoClient photoClient;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    @ApiOperation(value = "Get all photos", response = PhotoResponse[].class)
    public PhotoResponse[] getAll(@Valid PhotoRequest request) {
        logger.debug("Request received : {}", request);
        return photoClient.getAll(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(PHOTOS_RANDOM)
    @ApiOperation(value = "Get a random photo", response = PhotoResponse.class)
    public PhotoResponse random(@Valid RandomPhotoRequest request) {
        logger.debug("Request received : {}", request);
        return photoClient.random(request);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(PHOTOS_LIKE)
    @ApiOperation(value = "Like a photo", response = LikePhotoResponse.class)
    public LikePhotoResponse like(@Valid @RequestBody LikePhotoRequest request) {
        logger.debug("Request received : {}", request);
        return photoClient.like(request);
    }
}