package com.bynder.sdk.mapper;

import com.bynder.sdk.dto.response.PhotoUrlsResponse;
import com.bynder.sdk.dto.response.PhotosResponse;
import com.bynder.sdk.entities.PhotoUrlsEntity;
import com.bynder.sdk.entities.PhotoUrlsEntity.PhotoUrlsEntityBuilder;
import com.bynder.sdk.entities.PhotosEntity;
import com.bynder.sdk.entities.PhotosEntity.PhotosEntityBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-03-07T10:32:58+0100",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 15.0.1 (Oracle Corporation)"
)
@Component
public class PhotosEntityMapperImpl implements PhotosEntityMapper {

    @Override
    public PhotosEntity photosEntityFromPhotosResponse(PhotosResponse photosResponse) {
        if ( photosResponse == null ) {
            return null;
        }

        PhotosEntityBuilder photosEntity = PhotosEntity.builder();

        photosEntity.id( photosResponse.getId() );
        photosEntity.createdAt( photosResponse.getCreatedAt() );
        photosEntity.updatedAt( photosResponse.getUpdatedAt() );
        photosEntity.width( photosResponse.getWidth() );
        photosEntity.height( photosResponse.getHeight() );
        photosEntity.color( photosResponse.getColor() );
        photosEntity.altDescription( photosResponse.getAltDescription() );
        photosEntity.urls( photoUrlsResponseToPhotoUrlsEntity( photosResponse.getUrls() ) );
        photosEntity.likes( photosResponse.getLikes() );
        photosEntity.likedByUser( photosResponse.isLikedByUser() );

        return photosEntity.build();
    }

    @Override
    public List<PhotosEntity> photosEntityListFromPhotosResponseList(List<PhotosResponse> photosResponseList) {
        if ( photosResponseList == null ) {
            return null;
        }

        List<PhotosEntity> list = new ArrayList<PhotosEntity>( photosResponseList.size() );
        for ( PhotosResponse photosResponse : photosResponseList ) {
            list.add( photosEntityFromPhotosResponse( photosResponse ) );
        }

        return list;
    }

    protected PhotoUrlsEntity photoUrlsResponseToPhotoUrlsEntity(PhotoUrlsResponse photoUrlsResponse) {
        if ( photoUrlsResponse == null ) {
            return null;
        }

        PhotoUrlsEntityBuilder photoUrlsEntity = PhotoUrlsEntity.builder();

        photoUrlsEntity.raw( photoUrlsResponse.getRaw() );
        photoUrlsEntity.full( photoUrlsResponse.getFull() );
        photoUrlsEntity.regular( photoUrlsResponse.getRegular() );
        photoUrlsEntity.small( photoUrlsResponse.getSmall() );
        photoUrlsEntity.thumb( photoUrlsResponse.getThumb() );

        return photoUrlsEntity.build();
    }
}
