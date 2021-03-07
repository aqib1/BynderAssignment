package com.bynder.sdk.service.Impl;

import com.bynder.sdk.dto.response.AllPhotosResponse;
import com.bynder.sdk.mapper.PhotosResponseMapper;
import com.bynder.sdk.repository.Impl.InMemoryPhotosRepository;
import com.bynder.sdk.service.PhotosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhotosServiceImpl implements PhotosService {

    @Autowired
    private InMemoryPhotosRepository repository;

    @Autowired
    private PhotosResponseMapper mapper;

    public AllPhotosResponse getAll() {
        return AllPhotosResponse.builder()
                .photos(mapper.photosResponseListFromPhotosEntityList(repository.getAll()))
                .build();
    }
}
