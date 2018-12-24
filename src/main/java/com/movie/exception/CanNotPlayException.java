package com.movie.exception;

public class CanNotPlayException extends RuntimeException {
    public CanNotPlayException() {
    }

    public CanNotPlayException(String message) {
        super(message);
    }

    public CanNotPlayException(String message, Throwable cause) {
        super(message, cause);
    }
}
