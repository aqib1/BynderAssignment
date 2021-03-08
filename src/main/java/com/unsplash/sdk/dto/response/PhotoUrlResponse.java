package com.unsplash.sdk.dto.response;

import com.unsplash.sdk.dto.base.Base;
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
