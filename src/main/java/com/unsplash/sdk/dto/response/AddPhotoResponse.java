package com.unsplash.sdk.dto.response;

import com.unsplash.sdk.dto.base.Base;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddPhotoResponse extends Base {
    private PhotoResponse photo;
    private CollectionResponse collection;
}
