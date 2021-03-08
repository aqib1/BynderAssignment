package com.unsplash.sdk.dto.response;

import com.unsplash.sdk.dto.base.Base;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserProfileImageResponse extends Base {
    private String small;
    private String medium;
    private String large;
}
