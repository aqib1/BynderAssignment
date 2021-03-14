package com.unsplash.domain.response;

import com.unsplash.domain.base.Base;
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
