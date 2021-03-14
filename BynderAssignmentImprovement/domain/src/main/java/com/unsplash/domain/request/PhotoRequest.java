package com.unsplash.domain.request;

import com.unsplash.domain.base.Base;
import lombok.*;

import javax.validation.constraints.NotNull;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PhotoRequest extends Base {
    @NotNull(message = "Access token required for connection")
    private String accessToken;
}
