package com.unsplash.domain.response;

import com.unsplash.domain.base.Base;
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
