package com.unsplash.domain.request;

import com.unsplash.domain.base.Base;
import lombok.*;

import javax.validation.constraints.NotNull;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CollectionRequest extends Base {
    @NotNull(message = "Access token required for connection")
    private String accessToken;
    @NotNull(message = "title for collection must not be null")
    private String title;
    private String description;
    private boolean isPrivate;
}
