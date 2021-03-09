package com.unsplash.sdk.helper;

import org.springframework.http.MediaType;

public class Constants {
    public static final String BASE_PHOTOS = "/photos";
    public static final String PHOTOS_RANDOM = BASE_PHOTOS + "/random";
    public static final String PHOTOS_LIKE = BASE_PHOTOS + "/like";
    public static final String BASE_COLLECTIONS = "/collections";
    public static final String ADD_PHOTO_TO_COLLECTION = BASE_COLLECTIONS + "/add";
    public static final MediaType MEDIA_TYPE_JSON_UTF8 = new MediaType("application", "json");

    private Constants() {

    }
}
