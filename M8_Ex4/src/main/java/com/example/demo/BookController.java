package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

	// In-memory sample list of 10 books
	private List<Book> books = List.of(new Book(1, "Rey Lim", "The Lantern"),
			new Book(2, "Legolas Greenleaf", "Archery Mastery"), new Book(3, "Anna Cruz", "Spring Boot Essentials"),
			new Book(4, "John Santos", "REST API Design"), new Book(5, "Peter Quill", "Guardians of the Java"),
			new Book(6, "Bruce Banner", "The Science of Code"), new Book(7, "Tony Stark", "Full-Stack Armor Suit v1"),
			new Book(8, "Diana Prince", "Amazonian Algorithms"), new Book(9, "Clark Kent", "Debugging Kryptonite"),
			new Book(10, "Frodo Baggins", "Journey Through Microservices"));

	// ============================
	// 1. GET BY ID using @PathVariable
	// ============================
	@GetMapping("/{id}")
	public Book getBookById(@PathVariable int id) {
		return books.stream().filter(book -> book.getId() == id).findFirst().orElse(null);
	}

	// ============================
	// 2. SEARCH BOOK using @RequestParam (Exercise 8.4)
	// ============================

	@GetMapping("/search")
	public Book searchByAuthor(@RequestParam String name) {
		return books.stream().filter(book -> book.getAuthor().equalsIgnoreCase(name)).findFirst().orElse(null);
	}

}