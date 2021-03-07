package com.bynder.sdk.rest;

import com.bynder.sdk.dto.response.PhotosResponse;
import com.bynder.sdk.mapper.PhotosEntityMapper;
import com.bynder.sdk.repository.Impl.InMemoryPhotosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.Arrays;

@Component
public class PhotosClient {

    @Value("${access.key}")
    private String accessKey;

    @Value("${get.photos.url}")
    private String photosUrl;

    @Autowired
    private InMemoryPhotosRepository repository;

    @Autowired
    private PhotosEntityMapper mapper;

    @Autowired
    private WebClient webClient;

    public void loadPhotos() {
        repository.deleteAll();
        webClient.get()
                .uri(photosUrl)
                .header("Authorization", "Client-ID ".concat(accessKey))
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(PhotosResponse.class)

                .subscribe(photo ->
                        repository.addAll(mapper
                                .photosEntityListFromPhotosResponseList(Arrays
                                        .asList(photo))));
    }
}
