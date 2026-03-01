package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    // 10 sample books (Entity)
    private List<Book> books = List.of(
        new Book(1, "Rey Lim", "The Lantern"),
        new Book(2, "Legolas Greenleaf", "Archery Mastery"),
        new Book(3, "Anna Cruz", "Spring Boot Essentials"),
        new Book(4, "John Santos", "REST API Design"),
        new Book(5, "Peter Quill", "Guardians of the Java"),
        new Book(6, "Bruce Banner", "The Science of Code"),
        new Book(7, "Tony Stark", "Full-Stack Armor Suit v1"),
        new Book(8, "Diana Prince", "Amazonian Algorithms"),
        new Book(9, "Clark Kent", "Debugging Kryptonite"),
        new Book(10, "Frodo Baggins", "Journey Through Microservices")
    );

    // -----------------------------
    // 1. GET all books (Entity)
    // -----------------------------
    @GetMapping("/all")
    public List<Book> getAllBooks() {
        return books;
    }

    // -----------------------------
    // 2. GET a book by ID (Entity)
    // -----------------------------
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id) {
        return books.stream()
                .filter(b -> b.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // -----------------------------
    // 3. SEARCH using DTO (Exercise 8.8)
    // -----------------------------
    @GetMapping("/search")
    public BookDTO searchBook(
            @RequestParam String name,
            @RequestParam(defaultValue = "No title provided") String title) {

        BookDTO dto = new BookDTO();
        dto.setAuthor(name);
        dto.setTitle(title);

        return dto;
    }
}