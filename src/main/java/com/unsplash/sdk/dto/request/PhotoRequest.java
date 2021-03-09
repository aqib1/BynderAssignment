package com.unsplash.sdk.dto.request;

import lombok.*;

import javax.validation.constraints.NotNull;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PhotoRequest {
    @NotNull(message = "Access token required for connection")
    private String accessToken;
}
