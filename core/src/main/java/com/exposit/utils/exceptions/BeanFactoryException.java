package com.exposit.utils.exceptions;

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
