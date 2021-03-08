package com.unsplash.sdk.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.unsplash.sdk.dto.base.Base;
import lombok.*;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PhotoResponse extends Base {
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
    private PhotoUrlResponse urls;
    private int likes;
    @JsonProperty("liked_by_user")
    private boolean likedByUser;
    @JsonProperty("current_user_collections")
    private List<UserCollectionResponse> userCollectionResponse;

}
