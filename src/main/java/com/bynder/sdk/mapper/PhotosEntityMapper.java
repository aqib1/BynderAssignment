package com.bynder.sdk.mapper;

import com.bynder.sdk.dto.response.PhotosResponse;
import com.bynder.sdk.entities.PhotosEntity;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface PhotosEntityMapper {
    PhotosEntity photosEntityFromPhotosResponse(PhotosResponse photosResponse);
    List<PhotosEntity> photosEntityListFromPhotosResponseList(List<PhotosResponse> photosResponseList);
}
