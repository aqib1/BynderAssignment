package com.unsplash.sdk.dto.response;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LikePhotoResponse {
    private PhotoResponse photo;
}
