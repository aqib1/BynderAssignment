package com.unsplash.sdk.dto.response;

import com.unsplash.sdk.dto.base.Base;
import lombok.*;

import java.util.Collection;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AllPhotosResponse extends Base {
    private Collection<PhotoResponse> photos;
}
