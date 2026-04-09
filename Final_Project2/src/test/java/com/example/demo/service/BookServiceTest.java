package com.example.demo.service;

import com.example.demo.dao.Book;
import com.example.demo.exception.BookNotFoundException;
import com.example.demo.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Unit tests for BookService.
 */
@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    /**
     * Test fetching all books.
     */
    @Test
    void testGetAllBooks() {
        when(bookRepository.findAll()).thenReturn(
                List.of(
                        new Book("Clean Code", "Robert C. Martin", BigDecimal.valueOf(650))
                )
        );

        List<Book> books = bookService.getAll();

        assertEquals(1, books.size());
        assertEquals("Clean Code", books.get(0).getTitle());
        verify(bookRepository).findAll();
    }

    /**
     * Test fetching a book by ID when found.
     */
    @Test
    void testGetBookByIdFound() {
        Book book = new Book(
                "Effective Java",
                "Joshua Bloch",
                BigDecimal.valueOf(900)
        );

        when(bookRepository.findById(1)).thenReturn(Optional.of(book));

        Book result = bookService.getById(1);

        assertNotNull(result);
        assertEquals("Effective Java", result.getTitle());
        verify(bookRepository).findById(1);
    }

    /**
     * Test fetching a book by ID when not found.
     */
    @Test
    void testGetBookByIdNotFound() {
        when(bookRepository.findById(99)).thenReturn(Optional.empty());

        assertThrows(
                BookNotFoundException.class,
                () -> bookService.getById(99)
        );

        verify(bookRepository).findById(99);
    }

    /**
     * Test creating a book.
     */
    @Test
    void testCreateBook() {
        Book book = new Book(
                "Refactoring",
                "Martin Fowler",
                BigDecimal.valueOf(750)
        );

        when(bookRepository.save(any(Book.class))).thenReturn(book);

        Book saved = bookService.create(book);

        assertEquals("Refactoring", saved.getTitle());
        verify(bookRepository).save(book);
    }
}
