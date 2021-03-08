package com.unsplash.sdk.dto.response;

import com.unsplash.sdk.dto.base.Base;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LinksResponse extends Base {
     private String self;
     private String html;
     private String photos;
     private String related;
}
