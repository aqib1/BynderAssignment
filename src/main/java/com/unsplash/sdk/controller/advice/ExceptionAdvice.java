package com.unsplash.sdk.controller.advice;

import com.unsplash.sdk.dto.response.ResponseError;
import com.unsplash.sdk.exception.ErrorResponseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Optional;

@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(value
            = ErrorResponseException.class)
    public ResponseEntity<ResponseError> handleErrorResponseException(
            ErrorResponseException e) {
        String error = Optional.ofNullable(e.getMessage()).orElse(e.getClass().getName())
                + " [Internal server exception! => (ErrorResponseException)]";
        ResponseError errorResponse = ResponseError.builder()
                .createdAt(LocalDateTime.now().toString())
                .detailedMessage(error)
                .errorCode(e.getResponse().getStatusCode().value())
                .exceptionName(ErrorResponseException.class.getName())
                .errorMessage(e.getMessage()).build();
        return new ResponseEntity<>(errorResponse, e.getResponse().getStatusCode());
    }
}
