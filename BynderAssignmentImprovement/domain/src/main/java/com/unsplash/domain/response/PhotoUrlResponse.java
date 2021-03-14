package com.unsplash.domain.response;

import com.unsplash.domain.base.Base;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PhotoUrlResponse extends Base {
    private String raw;
    private String full;
    private String regular;
    private String small;
    private String thumb;
}
