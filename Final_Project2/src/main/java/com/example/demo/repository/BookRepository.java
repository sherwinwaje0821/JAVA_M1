package com.example.demo.repository;

import com.example.demo.dao.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for Book.
 */
public interface BookRepository extends JpaRepository<Book, Integer> {}
