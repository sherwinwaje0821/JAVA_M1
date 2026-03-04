package com.example.demo.controller;

import com.example.demo.dao.Movie;
import com.example.demo.dto.MovieDTO;
import com.example.demo.service.MovieService;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    // -----------------------------------
    // Mapper Methods
    // -----------------------------------
    private MovieDTO toDTO(Movie movie) {
        if (movie == null) return null;

        return new MovieDTO(
                movie.getTitle(),
                movie.getDirector(),
                movie.getYear(),
                movie.getGenre()
        );
    }

    private Movie toEntity(MovieDTO dto) {
        if (dto == null) return null;

        return new Movie(
                0,  // ID auto-assigned in service
                dto.getTitle(),
                dto.getDirector(),
                dto.getYear(),
                dto.getGenre()
        );
    }

    // -----------------------------------
    // GET ALL (DTO)
    // -----------------------------------
    @GetMapping("/all")
    public List<MovieDTO> getAllMovies() {
        return movieService.getAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    // -----------------------------------
    // GET BY ID (DTO)
    // -----------------------------------
    @GetMapping("/{id}")
    public ResponseEntity<MovieDTO> getMovieById(@PathVariable int id) {
        Movie movie = movieService.getById(id);

        if (movie == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(toDTO(movie));
    }

    // -----------------------------------
    // POST - CREATE (DTO)
    // -----------------------------------
    @PostMapping
    public ResponseEntity<MovieDTO> createMovie(@RequestBody MovieDTO dto) {

        Movie movieToSave = toEntity(dto);
        Movie savedMovie = movieService.create(movieToSave);

        URI location = URI.create("/api/v1/movies/" + savedMovie.getId());

        return ResponseEntity
                .created(location)
                .body(toDTO(savedMovie));
    }

    // -----------------------------------
    // DELETE
    // -----------------------------------
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable int id) {
        boolean removed = movieService.delete(id);

        if (removed) {
            return ResponseEntity.ok("Movie deleted.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                 .body("Movie not found.");
        }
    }

    // -----------------------------------
    // SEARCH (DTO)
    // -----------------------------------
    @GetMapping("/search")
    public MovieDTO searchMovie(
            @RequestParam String director,
            @RequestParam(defaultValue = "Unknown Title") String title
    ) {
        return new MovieDTO(
                title,
                director,
                2024,
                "Unknown"
        );
    }
}