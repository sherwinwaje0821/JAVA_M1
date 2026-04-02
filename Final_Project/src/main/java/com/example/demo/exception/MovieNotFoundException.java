package com.example.demo.exception;

public class MovieNotFoundException extends RuntimeException {

    public MovieNotFoundException(int id) {
        super("Movie not found with id: " + id);
    }
}