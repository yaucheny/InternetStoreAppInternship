package com.exposit.utils.exceptions;

/**
 * Custom exception class represents BeanFactoryException. Extends RuntimeException.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
public class BeanFactoryException extends RuntimeException {

    public BeanFactoryException(String message) {
        super(message);
    }

    public BeanFactoryException(String message, Throwable cause) {
        super(message, cause);
    }

    public BeanFactoryException(Throwable cause) {
        super(cause);
    }
}
