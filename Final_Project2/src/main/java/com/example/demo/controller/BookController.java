package com.example.demo.controller;

import com.example.demo.dto.BookDTO;
import com.example.demo.dao.Book;
import com.example.demo.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for Book operations.
 */
@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    private BookDTO toDTO(Book book) {
        return new BookDTO(book.getTitle(), book.getAuthor(), book.getPrice());
    }

    private Book toEntity(BookDTO dto) {
        return new Book(dto.getTitle(), dto.getAuthor(), dto.getPrice());
    }

    @GetMapping
    public List<BookDTO> getAll() {
        return service.getAll().stream().map(this::toDTO).toList();
    }

    @GetMapping("/{id}")
    public BookDTO get(@PathVariable int id) {
        return toDTO(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<BookDTO> create(@Valid @RequestBody BookDTO dto) {
        return ResponseEntity.ok(toDTO(service.create(toEntity(dto))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.ok("Book deleted successfully");
    }
}
