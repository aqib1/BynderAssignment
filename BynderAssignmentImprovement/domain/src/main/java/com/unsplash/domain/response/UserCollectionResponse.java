package com.unsplash.domain.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.unsplash.domain.base.Base;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserCollectionResponse extends Base {
    private int id;
    private String title;
    @JsonProperty("published_at")
    private String publishedAt;
    @JsonProperty("last_collected_at")
    private String lastCollectedAt;
    @JsonProperty("updated_at")
    private String updatedAt;
    @JsonProperty("cover_photo")
    private String coverPhoto;
}
