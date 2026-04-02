package com.example.demo.controller;

import com.example.demo.dao.Movie;
import com.example.demo.dto.MovieDTO;
import com.example.demo.service.MovieService;
import org.springframework.http.ResponseEntity;
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

    private MovieDTO toDTO(Movie movie) {
        return new MovieDTO(
                movie.getTitle(),
                movie.getDirector(),
                movie.getYear(),
                movie.getGenre()
        );
    }

    private Movie toEntity(MovieDTO dto) {
        return new Movie(
                dto.getTitle(),
                dto.getDirector(),
                dto.getYear(),
                dto.getGenre()
        );
    }

    @GetMapping("/all")
    public List<MovieDTO> getAllMovies() {
        return movieService.getAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

     

@GetMapping("/{id}")
public MovieDTO getMovie(@PathVariable int id) {
    return toDTO(movieService.getById(id));
}


    @PostMapping
    public ResponseEntity<MovieDTO> createMovie(@RequestBody MovieDTO dto) {
        Movie saved = movieService.create(toEntity(dto));
        return ResponseEntity
                .created(URI.create("/api/v1/movies/" + saved.getId()))
                .body(toDTO(saved));
    }


@DeleteMapping("/{id}")
public ResponseEntity<String> deleteMovie(@PathVariable int id) {
    movieService.delete(id);
    return ResponseEntity.ok("Movie deleted");
}

}
