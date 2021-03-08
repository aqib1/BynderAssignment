package com.unsplash.sdk.controller;

import com.unsplash.sdk.client.PhotoClient;
import com.unsplash.sdk.dto.response.PhotoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import static com.unsplash.sdk.utils.Constants.BASE_PHOTOS;


@RestController
@RequestMapping(BASE_PHOTOS)
public class PhotoController {
    @Autowired
    private PhotoClient photoClient;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public PhotoResponse[] getAll() {
        return photoClient.loadPhotos();
    }

}
