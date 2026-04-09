package com.example.demo.service;

import com.example.demo.dao.Book;
import com.example.demo.exception.BookDeletionException;
import com.example.demo.exception.BookNotFoundException;
import com.example.demo.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Service layer containing business logic.
 */
@Service
public class BookService {

    private static final Logger log = LoggerFactory.getLogger(BookService.class);
    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public List<Book> getAll() {
        log.info("Fetching all books");
        return repository.findAll();
    }

    public Book getById(int id) {
        log.info("Fetching book {}", id);
        return repository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
    }

    public Book create(Book book) {
        log.info("Creating book {}", book.getTitle());
        return repository.save(book);
    }

    /**
     * Delete book only if:
     * - At least 1 week old
     * - Not older than 1 year
     */
    public void delete(int id) {
        Book book = getById(id);
        LocalDateTime now = LocalDateTime.now();

        if (book.getCreatedAt().isAfter(now.minusWeeks(1))) {
            throw new BookDeletionException("Book must be at least 1 week old.");
        }

        if (book.getCreatedAt().isBefore(now.minusYears(1))) {
            throw new BookDeletionException("Book older than 1 year cannot be deleted.");
        }

        repository.deleteById(id);
        log.warn("Deleted book {}", id);
    }
}