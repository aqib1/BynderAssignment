package com.unsplash.sdk.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotNull;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LikePhotoRequest {
    @NotNull(message = "Access token required for connection")
    private String accessToken;
    @JsonProperty(value = "photo_id")
    @NotNull(message = "Photo id required")
    private String photoId;
}
