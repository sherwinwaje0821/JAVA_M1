package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        
        /*
         * 
         * get
http://localhost:9091/api/v1/movies/all
get
http://localhost:9091/api/v1/movies/1
post
http://localhost:9091/api/v1/movies
{
  "title": "Titanic",
  "director": "James Cameron",
  "year": 1997,
  "genre": "Romance"
}
delete
http://localhost:9091/api/v1/movies/6

DROP TABLE IF EXISTS movies;
CREATE TABLE movies (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    director VARCHAR(255) NOT NULL,
    year INTEGER NOT NULL,
    genre VARCHAR(100) NOT NULL
);

INSERT INTO movies (title, director, year, genre) VALUES
('The Shawshank Redemption', 'Frank Darabont', 1994, 'Drama'),
('The Godfather', 'Francis Ford Coppola', 1972, 'Crime'),
('The Dark Knight', 'Christopher Nolan', 2008, 'Action'),
('Pulp Fiction', 'Quentin Tarantino', 1994, 'Crime'),
('Forrest Gump', 'Robert Zemeckis', 1994, 'Drama'),
('Inception', 'Christopher Nolan', 2010, 'Sci-Fi'),
('Fight Club', 'David Fincher', 1999, 'Drama'),
('Interstellar', 'Christopher Nolan', 2014, 'Sci-Fi'),
('The Matrix', 'The Wachowskis', 1999, 'Sci-Fi'),
('Gladiator', 'Ridley Scott', 2000, 'Action');

SELECT * FROM movies ORDER BY id;

         */
    }
}