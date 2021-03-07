package com.bynder.sdk.repository;

import com.bynder.sdk.entities.PhotosEntity;
import java.util.List;

public interface PhotosRepository {
    List<PhotosEntity> getAll();
    void addAll(List<PhotosEntity> photos);
    void add(PhotosEntity photo);
    void deleteAll();
}
