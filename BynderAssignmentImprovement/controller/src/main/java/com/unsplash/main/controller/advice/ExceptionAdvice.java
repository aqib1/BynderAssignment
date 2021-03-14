package com.unsplash.main.controller.advice;

import com.unsplash.domain.exceptions.ErrorResponseException;
import com.unsplash.domain.response.ResponseError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

import java.time.LocalDateTime;
import java.util.Optional;

@RestControllerAdvice
public class ExceptionAdvice {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionAdvice.class);

    @ExceptionHandler(value
            = ErrorResponseException.class)
    public ResponseEntity<ResponseError> handleErrorResponseException(
            ErrorResponseException e) {
        logger.error("Exception captured : {}", e);
        String error = Optional.ofNullable(e.getMessage()).orElse(e.getClass().getName())
                + " [Internal server exception! => (ErrorResponseException)]";
        ResponseError errorResponse = ResponseError.builder()
                .createdAt(LocalDateTime.now().toString())
                .detailedMessage(error)
                .errorCode(e.getResponse().getStatusCode().value())
                .exceptionName(ErrorResponseException.class.getName())
                .errorMessage(e.getMessage()).build();
        logger.error("Response error created : {}", errorResponse);
        return new ResponseEntity<>(errorResponse, e.getResponse().getStatusCode());
    }

    @ExceptionHandler(value
            = HttpClientErrorException.class)
    public ResponseEntity<ResponseError> handleHttpClientErrorException(
            HttpClientErrorException e) {
        logger.error("Exception captured : ", e);
        String error = Optional.ofNullable(e.getMessage()).orElse(e.getClass().getName())
                + " [Internal server exception! => (HttpClientErrorException)]";
        ResponseError errorResponse = ResponseError.builder()
                .createdAt(LocalDateTime.now().toString())
                .detailedMessage(error)
                .errorCode(e.getStatusCode().value())
                .exceptionName(HttpClientErrorException.class.getName())
                .errorMessage(e.getMessage()).build();
        logger.error("Response error created : {}", errorResponse);
        return new ResponseEntity<>(errorResponse, e.getStatusCode());
    }

    @ExceptionHandler(value
            = RuntimeException.class)
    public ResponseEntity<ResponseError> handleRuntimeException(
            RuntimeException e) {
        logger.error("Exception captured : ", e);
        String error = Optional.ofNullable(e.getMessage()).orElse(e.getClass().getName())
                + " [Internal server exception! => (RuntimeException)]";
        ResponseError errorResponse = ResponseError.builder()
                .createdAt(LocalDateTime.now().toString())
                .detailedMessage(error)
                .errorCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .exceptionName(RuntimeException.class.getName())
                .errorMessage(e.getMessage()).build();
        logger.error("Response error created : {}", errorResponse);
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
