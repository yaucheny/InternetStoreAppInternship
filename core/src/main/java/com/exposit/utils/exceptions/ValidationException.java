package com.exposit.utils.exceptions;
/**
 * Custom exception class represents ValidationException. Extends RuntimeException.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
public class ValidationException extends RuntimeException {

    public ValidationException(String message) {
        super(message);
    }

    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidationException(Throwable cause) {
        super(cause);
    }
}
