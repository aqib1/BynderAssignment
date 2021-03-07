package com.bynder.sdk.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.bynder.sdk.utils.URLS.ADD_PHOTO_TO_COLLECTION;
import static com.bynder.sdk.utils.URLS.BASE_COLLECTIONS;

@RestController
@RequestMapping(BASE_COLLECTIONS)
public class CollectionsController {

    @GetMapping
    public void getAll() {

    }

    @PostMapping
    public void create() {

    }

    @PostMapping(ADD_PHOTO_TO_COLLECTION)
    public void addPhoto(){

    }
}
