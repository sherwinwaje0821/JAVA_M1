package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/books")
public class BookController {

    // Static list of 3 books
    private List<Book> books = Arrays.asList(
            new Book(1, "Spring Boot Basics", "Author A"),
            new Book(2, "Java Fundamentals", "Author B"),
            new Book(3, "REST API Design", "Author C")
    );

    // GET /api/books
    @GetMapping
    public List<Book> getAllBooks() {
        return books;
    }

    // GET /api/books/{id}
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id) {
        return books.stream()
                .filter(b -> b.getId() == id)
                .findFirst()
                .orElse(null); // or throw exception
    }
}