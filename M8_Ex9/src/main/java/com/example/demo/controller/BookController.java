package com.example.demo.controller;

import com.example.demo.dao.Book;
import com.example.demo.dto.BookDTO;
import com.example.demo.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    @Autowired
    private BookService bookService;

    // -----------------------------
    // GET ALL
    // -----------------------------
    @GetMapping("/all")
    List<Book> getAllBooks() {
        return bookService.getAll();
    }

    // -----------------------------
    // GET BY ID
    // -----------------------------
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id) {
        return bookService.getById(id);
    }

    // -----------------------------
    // POST - Create (Return 201 Created)
    // -----------------------------
    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {

        Book savedBook = bookService.create(book);

        // Location header: /api/v1/books/{id}
        URI location = URI.create("/api/v1/books/" + savedBook.getId());

        return ResponseEntity
                .created(location)      // <-- 201 Created
                .body(savedBook);       // Response body
    }

    // -----------------------------
    // DELETE
    // -----------------------------
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable int id) {
        boolean removed = bookService.delete(id);

        if (removed) {
            return ResponseEntity.ok("Book deleted.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found.");
        }
    }

    // -----------------------------
    // OPTIONAL — DTO SEARCH ENDPOINT
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