package com.bynder.sdk.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.Collection;

@Data
@Builder
public class AllPhotosResponse {
    private Collection<PhotosResponse> photos;
}
