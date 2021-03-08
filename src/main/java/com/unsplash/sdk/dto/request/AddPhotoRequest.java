package com.unsplash.sdk.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.unsplash.sdk.dto.base.Base;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
@Data
@Builder
public class AddPhotoRequest extends Base {
    @NotNull(message = "Access token required for connection")
    private String accessToken;
    @JsonProperty(value = "photo_id")
    @NotNull(message = "Photo id required")
    private String photoId;
    @JsonProperty("collection_id")
    @NotNull(message = "Collection id required")
    private String collectionId;
}
