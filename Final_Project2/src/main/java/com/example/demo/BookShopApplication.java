 

package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point for the Book Shop application.
 */
@SpringBootApplication
public class BookShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookShopApplication.class, args);

        
        /*
         * 

DROP TABLE IF EXISTS books;

CREATE TABLE books (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    price NUMERIC(10, 2) NOT NULL CHECK (price > 0),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);


INSERT INTO books (title, author, price, created_at) VALUES
-- Less than 1 week old (DELETE should FAIL)
('Spring Boot in Action', 'Craig Walls', 799.00, NOW() - INTERVAL '2 days'),
('Effective Java', 'Joshua Bloch', 899.00, NOW() - INTERVAL '5 days'),

-- Just over 1 week old (DELETE should SUCCEED)
('Clean Code', 'Robert C. Martin', 650.00, NOW() - INTERVAL '8 days'),
('Java Concurrency in Practice', 'Brian Goetz', 850.00, NOW() - INTERVAL '10 days'),

-- Few months old (DELETE should SUCCEED)
('Design Patterns', 'Erich Gamma', 999.00, NOW() - INTERVAL '2 months'),
('Refactoring', 'Martin Fowler', 750.00, NOW() - INTERVAL '6 months'),

-- Almost 1 year old (DELETE should SUCCEED)
('Head First Java', 'Kathy Sierra', 550.00, NOW() - INTERVAL '11 months'),
('Microservices Patterns', 'Chris Richardson', 880.00, NOW() - INTERVAL '11 months'),

-- Older than 1 year (DELETE should FAIL)
('Domain‑Driven Design', 'Eric Evans', 1050.00, NOW() - INTERVAL '2 years'),
('Spring in Depth', 'Mark Pollack', 920.00, NOW() - INTERVAL '3 years');


GET http://localhost:9091/api/books
GET http://localhost:9091/api/books/1
POST http://localhost:9091/api/books
{
  "title": "Clean Architecture",
  "author": "Robert C. Martin",
  "price": 899
}
DELETE http://localhost:9091/api/books/1
DELETE http://localhost:9091/api/books/9
DELETE http://localhost:9091/api/books/3

         */
    }
}