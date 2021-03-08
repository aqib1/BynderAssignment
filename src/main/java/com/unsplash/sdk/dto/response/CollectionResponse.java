package com.unsplash.sdk.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.unsplash.sdk.dto.base.Base;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CollectionResponse extends Base {
    private String id;
    private String title;
    private String description;
    @JsonProperty("published_at")
    private String publishedAt;
    @JsonProperty("last_collected_at")
    private String lastCollectedAt;
    @JsonProperty("updatedAt")
    private String updated_at;
    private boolean curated;
    private boolean featured;
    @JsonProperty("total_photos")
    private int totalPhotos;
    private boolean isPrivate;
    @JsonProperty("share_key")
    private String shareKey;
    private LinksResponse links;
    private UserResponse user;
}
