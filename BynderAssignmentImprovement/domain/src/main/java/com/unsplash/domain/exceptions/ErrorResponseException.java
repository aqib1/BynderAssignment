package com.unsplash.domain.exceptions;

import org.springframework.http.ResponseEntity;

import java.io.Serial;

public class ErrorResponseException extends RuntimeException {

    private ResponseEntity<String> response;
    /**
     *
     */
    @Serial
    private static final long serialVersionUID = 2809306975311109014L;



    public ErrorResponseException(String message) {
        super(message);
    }

    public ErrorResponseException(String message, ResponseEntity<String> response) {
        this(message);
        this.response = response;
    }

	public ResponseEntity<String> getResponse() {
		return response;
	}
}