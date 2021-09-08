package com.exposit.utils.exceptions;

/**
 * Custom exception class represents DaoException. Extends RuntimeException.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
public class DaoException extends RuntimeException {

    public DaoException(String message) {
        super(message);
    }

    public DaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public DaoException(Throwable cause) {
        super(cause);
    }
}
