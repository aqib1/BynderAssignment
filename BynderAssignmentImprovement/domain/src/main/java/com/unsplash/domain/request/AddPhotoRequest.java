package com.unsplash.domain.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.unsplash.domain.base.Base;
import lombok.*;
import javax.validation.constraints.NotNull;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
