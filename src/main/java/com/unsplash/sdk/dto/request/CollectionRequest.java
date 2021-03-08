package com.unsplash.sdk.dto.request;

import com.unsplash.sdk.dto.base.Base;
import lombok.Builder;
import lombok.Data;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class CollectionRequest extends Base {
    @NotNull(message = "Access token required for connection")
    private String accessToken;
    @NotNull(message = "title for collection must not be null")
    private String title;
    private String description;
    private boolean isPrivate;
}
