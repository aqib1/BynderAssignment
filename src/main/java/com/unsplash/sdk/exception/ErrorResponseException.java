package com.unsplash.sdk.exception;

import org.springframework.http.ResponseEntity;

public class ErrorResponseException extends RuntimeException {

    private ResponseEntity<String> response;
    /**
     *
     */
    private static final long serialVersionUID = 2809306975311109014L;


    /**
     * @param message
     */
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