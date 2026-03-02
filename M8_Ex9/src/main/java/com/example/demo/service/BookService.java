package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.dao.Book;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private final List<Book> books = new ArrayList<>();

    public BookService() {
        // Initial sample data
        books.add(new Book(1, "Rey Lim", "The Lantern"));
        books.add(new Book(2, "Legolas Greenleaf", "Archery Mastery"));
        books.add(new Book(3, "Anna Cruz", "Spring Boot Essentials"));
    }

    // CREATE
    public Book create(Book book) {
        books.add(book);
        return book;
    }

    // READ - get all
    public List<Book> getAll() {
        return books;
    }

    // READ - get by ID
    public Book getById(int id) {
        return books.stream()
                .filter(b -> b.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // DELETE
    public boolean delete(int id) {
        return books.removeIf(b -> b.getId() == id);
    }
}