package com.bynder.sdk.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PhotoUrlsEntity {
    private String raw;
    private String full;
    private String regular;
    private String small;
    private String thumb;
}
