package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * Centralized exception handling.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleNotFound(BookNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
            Map.of(
                "timestamp", LocalDateTime.now(),
                "error", ex.getMessage()
            )
        );
    }

    @ExceptionHandler(BookDeletionException.class)
    public ResponseEntity<Map<String, Object>> handleDeleteError(BookDeletionException ex) {
        return ResponseEntity.badRequest().body(
            Map.of(
                "timestamp", LocalDateTime.now(),
                "error", ex.getMessage()
            )
        );
    }
}
