package com.example.demo.service;

import com.example.demo.dao.Movie;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    private final List<Movie> movies = new ArrayList<>();
    private int nextId = 1;

    public MovieService() {
        // Initial sample data
        movies.add(new Movie(nextId++, "The Shawshank Redemption", "Frank Darabont", 1994, "Drama"));
        movies.add(new Movie(nextId++, "Inception", "Christopher Nolan", 2010, "Sci-Fi"));
        movies.add(new Movie(nextId++, "The Godfather", "Francis Ford Coppola", 1972, "Crime"));
        movies.add(new Movie(nextId++, "The Dark Knight", "Christopher Nolan", 2008, "Action"));
        movies.add(new Movie(nextId++, "Interstellar", "Christopher Nolan", 2014, "Sci-Fi"));
    }

    // -----------------------------
    // GET ALL MOVIES
    // -----------------------------
    public List<Movie> getAll() {
        return movies;
    }

    // -----------------------------
    // GET MOVIE BY ID
    // -----------------------------
    public Movie getById(int id) {
        return movies.stream()
                .filter(movie -> movie.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // -----------------------------
    // CREATE MOVIE
    // -----------------------------
    public Movie create(Movie movie) {
        movie.setId(nextId++);
        movies.add(movie);
        return movie;
    }

    // -----------------------------
    // DELETE MOVIE
    // -----------------------------
    public boolean delete(int id) {
        return movies.removeIf(movie -> movie.getId() == id);
    }
}