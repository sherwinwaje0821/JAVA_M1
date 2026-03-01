package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/books")
public class BookController {

    // sample list of books (in-memory)
    private List<Book> books = List.of(
        new Book(1, "Rey Lim", "The Lantern"),
        new Book(2, "Mark Rivera", "Java for Beginners"),
        new Book(3, "Anna Cruz", "Spring Boot Essentials"),
        new Book(4, "John Santos", "REST API Design")
    );

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id) {

        // find the book matching the id
        return books.stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .orElse(null); // returns null if not found
    }
}