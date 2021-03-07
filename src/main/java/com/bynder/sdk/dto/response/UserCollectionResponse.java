package com.bynder.sdk.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserCollectionResponse {
    private int id;
    private String title;
    @JsonProperty("published_at")
    private String publishedAt;
    @JsonProperty("last_collected_at")
    private String lastCollectedAt;
    @JsonProperty("updated_at")
    private String updatedAt;
    @JsonProperty("cover_photo")
    private String coverPhoto;
}
