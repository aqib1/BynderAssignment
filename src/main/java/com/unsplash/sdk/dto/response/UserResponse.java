package com.unsplash.sdk.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.unsplash.sdk.dto.base.Base;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserResponse extends Base {
    private String id;
    private String updated_at;
    private String username;
    private String name;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("twitter_username")
    private String twitterUsername;
    @JsonProperty("portfolio_url")
    private String portfolioUrl;
    private String bio;
    private String location;
    @JsonProperty("instagram_username")
    private String instagramUsername;
    @JsonProperty("total_collections")
    private int totalCollections;
    @JsonProperty("total_likes")
    private int totalLikes;
    @JsonProperty("totalPhotos")
    private int totalPhotos;
    @JsonProperty("profile_image")
    private UserProfileImageResponse profileImage;
}
