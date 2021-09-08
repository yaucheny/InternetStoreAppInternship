package com.exposit.utils.exceptions;

/**
 * Custom exception class represents NotFoundException. Extends RuntimeException.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundException(Throwable cause) {
        super(cause);
    }
}
