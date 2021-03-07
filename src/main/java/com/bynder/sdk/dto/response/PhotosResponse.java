package com.bynder.sdk.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;

@Data
public class PhotosResponse {
    private String id;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("updated_at")
    private String updatedAt;
    private int width;
    private int height;
    private String color;
    @JsonProperty("alt_description")
    private String altDescription;
    private PhotoUrlsResponse urls;
    private int likes;
    @JsonProperty("liked_by_user")
    private boolean likedByUser;
    @JsonProperty("current_user_collections")
    private List<UserCollectionResponse> userCollectionResponse;

}
