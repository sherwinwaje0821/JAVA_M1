package com.example.demo.controller;

import com.example.demo.dao.Book;
import com.example.demo.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BookController.class)
class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Autowired
    private ObjectMapper objectMapper;

    // ✅ TEST: GET ALL BOOKS
    @Test
    @WithMockUser(username = "admin", roles = {"USER"})
    void testGetAllBooks() throws Exception {

        Book book = new Book();
        book.setId(1);
        book.setTitle("Clean Code");
        book.setAuthor("Robert C. Martin");
        book.setPrice(BigDecimal.valueOf(650));

        when(bookService.getAll()).thenReturn(List.of(book));

        mockMvc.perform(get("/api/books"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Clean Code"))
                .andExpect(jsonPath("$[0].author").value("Robert C. Martin"));
    }

    // ✅ TEST: CREATE BOOK (POST + CSRF)
    @Test
    @WithMockUser(username = "admin", roles = {"USER"})
    void testCreateBook() throws Exception {

        Book savedBook = new Book();
        savedBook.setId(1);
        savedBook.setTitle("Effective Java");
        savedBook.setAuthor("Joshua Bloch");
        savedBook.setPrice(BigDecimal.valueOf(900));

        when(bookService.create(org.mockito.ArgumentMatchers.any(Book.class)))
                .thenReturn(savedBook);

        String requestBody = """
                {
                  "title": "Effective Java",
                  "author": "Joshua Bloch",
                  "price": 900
                }
                """;

        mockMvc.perform(post("/api/books")
                        .with(csrf()) // ✅ NOW RESOLVES CORRECTLY
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Effective Java"))
                .andExpect(jsonPath("$.author").value("Joshua Bloch"));
    }
}
