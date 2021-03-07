package com.bynder.sdk.entities;

import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class PhotosEntity {
    private String id;
    private String createdAt;
    private String updatedAt;
    private int width;
    private int height;
    private String color;
    private String altDescription;
    private PhotoUrlsEntity urls;
    private int likes;
    private boolean likedByUser;
    private List<UserCollectionEntity> userCollection;
}
