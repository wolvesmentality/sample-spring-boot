package com.wolvesmentality.exception;

public class AppRuntimeException extends RuntimeException {

    public AppRuntimeException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
