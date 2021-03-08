package com.unsplash.sdk.exception;

public class DataNotFoundException extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = 8093069298798129014L;

    public DataNotFoundException() {

    }

    /**
     * @param message
     */
    public DataNotFoundException(String message) {
        super(message);
    }

    /**
     * @param message
     * @param throwable
     */
    public DataNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
