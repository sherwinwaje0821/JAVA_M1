package com.example.demo.exception;

/**
 * Thrown when delete rules are violated.
 */
public class BookDeletionException extends RuntimeException {
    public BookDeletionException(String message) {
        super(message);
    }
}
