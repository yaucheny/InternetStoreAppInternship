package com.exposit.utils.exceptions;
/**
 * Custom exception class represents FileNotFoundException. Extends RuntimeException.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
public class FileNotFoundException extends RuntimeException {

    public FileNotFoundException(String message) {
        super(message);
    }

    public FileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileNotFoundException(Throwable cause) {
        super(cause);
    }
}
