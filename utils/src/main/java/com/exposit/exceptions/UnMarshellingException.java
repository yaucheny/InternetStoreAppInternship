package com.exposit.exceptions;

public class UnMarshellingException extends RuntimeException {

    public UnMarshellingException(String message) {
        super(message);
    }

    public UnMarshellingException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnMarshellingException(Throwable cause) {
        super(cause);
    }
}
