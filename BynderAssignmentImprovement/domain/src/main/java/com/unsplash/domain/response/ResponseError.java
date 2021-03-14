package com.unsplash.domain.response;

import com.unsplash.domain.base.Base;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseError extends Base {
    private String createdAt;
    private String detailedMessage;
    private int errorCode;
    private String exceptionName;
    private String errorMessage;
}