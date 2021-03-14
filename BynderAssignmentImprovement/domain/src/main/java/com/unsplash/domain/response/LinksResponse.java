package com.unsplash.domain.response;

import com.unsplash.domain.base.Base;
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
