package com.exposit.utils.exceptions;
/**
 * Custom exception class represents ServiceException. Extends RuntimeException.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
public class ServiceException extends RuntimeException {

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }
}
