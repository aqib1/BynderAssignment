package com.unsplash.domain.response;

import com.unsplash.domain.base.Base;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LikePhotoResponse extends Base {
    private PhotoResponse photo;
}
