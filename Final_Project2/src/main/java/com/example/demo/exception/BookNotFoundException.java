package com.example.demo.exception;

/**
 * Thrown when a book is not found.
 */
public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(int id) {
        super("Book not found with id: " + id);
    }
}
