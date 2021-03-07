package com.bynder.sdk.dto.response;

import lombok.Data;

@Data
public class PhotoUrlsResponse {
    private String raw;
    private String full;
    private String regular;
    private String small;
    private String thumb;
}
