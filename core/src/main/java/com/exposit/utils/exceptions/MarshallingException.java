package com.exposit.utils.exceptions;

public class MarshallingException extends RuntimeException {

    public MarshallingException(String message) {
        super(message);
    }

    public MarshallingException(String message, Throwable cause) {
        super(message, cause);
    }

    public MarshallingException(Throwable cause) {
        super(cause);
    }
}
