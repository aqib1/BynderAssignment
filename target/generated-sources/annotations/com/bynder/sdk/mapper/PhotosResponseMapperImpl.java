package com.bynder.sdk.mapper;

import com.bynder.sdk.dto.response.PhotoUrlsResponse;
import com.bynder.sdk.dto.response.PhotosResponse;
import com.bynder.sdk.entities.PhotoUrlsEntity;
import com.bynder.sdk.entities.PhotosEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-03-07T10:32:57+0100",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 15.0.1 (Oracle Corporation)"
)
@Component
public class PhotosResponseMapperImpl implements PhotosResponseMapper {

    @Override
    public PhotosResponse photosResponseFromPhotosEntity(PhotosEntity photosEntity) {
        if ( photosEntity == null ) {
            return null;
        }

        PhotosResponse photosResponse = new PhotosResponse();

        photosResponse.setId( photosEntity.getId() );
        photosResponse.setCreatedAt( photosEntity.getCreatedAt() );
        photosResponse.setUpdatedAt( photosEntity.getUpdatedAt() );
        photosResponse.setWidth( photosEntity.getWidth() );
        photosResponse.setHeight( photosEntity.getHeight() );
        photosResponse.setColor( photosEntity.getColor() );
        photosResponse.setAltDescription( photosEntity.getAltDescription() );
        photosResponse.setUrls( photoUrlsEntityToPhotoUrlsResponse( photosEntity.getUrls() ) );
        photosResponse.setLikes( photosEntity.getLikes() );
        photosResponse.setLikedByUser( photosEntity.isLikedByUser() );

        return photosResponse;
    }

    @Override
    public List<PhotosResponse> photosResponseListFromPhotosEntityList(List<PhotosEntity> photosEntityList) {
        if ( photosEntityList == null ) {
            return null;
        }

        List<PhotosResponse> list = new ArrayList<PhotosResponse>( photosEntityList.size() );
        for ( PhotosEntity photosEntity : photosEntityList ) {
            list.add( photosResponseFromPhotosEntity( photosEntity ) );
        }

        return list;
    }

    protected PhotoUrlsResponse photoUrlsEntityToPhotoUrlsResponse(PhotoUrlsEntity photoUrlsEntity) {
        if ( photoUrlsEntity == null ) {
            return null;
        }

        PhotoUrlsResponse photoUrlsResponse = new PhotoUrlsResponse();

        photoUrlsResponse.setRaw( photoUrlsEntity.getRaw() );
        photoUrlsResponse.setFull( photoUrlsEntity.getFull() );
        photoUrlsResponse.setRegular( photoUrlsEntity.getRegular() );
        photoUrlsResponse.setSmall( photoUrlsEntity.getSmall() );
        photoUrlsResponse.setThumb( photoUrlsEntity.getThumb() );

        return photoUrlsResponse;
    }
}
