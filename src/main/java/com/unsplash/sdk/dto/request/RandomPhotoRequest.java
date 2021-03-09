package com.unsplash.sdk.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.unsplash.sdk.dto.base.Base;
import lombok.*;
import javax.validation.constraints.NotNull;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RandomPhotoRequest extends Base {
    @JsonProperty(value = "content_filter", defaultValue = "false")
    private String contentFilter;
    private String username;
    private String query;
    private String orientation;
    @JsonProperty(defaultValue = "1")
    private int count;
    @NotNull(message = "Access token required for connection")
    private String accessToken;
}
