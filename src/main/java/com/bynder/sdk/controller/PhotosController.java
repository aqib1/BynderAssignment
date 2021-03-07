package com.bynder.sdk.controller;

import com.bynder.sdk.dto.response.AllPhotosResponse;
import com.bynder.sdk.dto.response.PhotosResponse;
import com.bynder.sdk.service.Impl.PhotosServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.bynder.sdk.utils.URLS.BASE_PHOTOS;

@RestController
@RequestMapping(BASE_PHOTOS)
public class PhotosController {

    @Autowired
    private PhotosServiceImpl service;

    @GetMapping
    public ResponseEntity<AllPhotosResponse> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
}
