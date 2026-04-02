package com.example.demo.service;

import com.example.demo.dao.Movie;
import com.example.demo.exception.MovieNotFoundException;
import com.example.demo.repository.MovieRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MovieServiceTest {

    @Mock
    private MovieRepository movieRepository;

    @InjectMocks
    private MovieService movieService;

    @Test
    void testGetAllMovies() {
        when(movieRepository.findAll())
                .thenReturn(List.of(
                        new Movie("Inception", "Christopher Nolan", 2010, "Sci‑Fi")
                ));

        List<Movie> movies = movieService.getAll();

        assertEquals(1, movies.size());
        verify(movieRepository).findAll();
    }

    @Test
    void testGetMovieByIdFound() {
        Movie movie = new Movie("Interstellar", "Christopher Nolan", 2014, "Sci‑Fi");

        when(movieRepository.findById(1))
                .thenReturn(Optional.of(movie));

        Movie result = movieService.getById(1);

        assertNotNull(result);
        assertEquals("Interstellar", result.getTitle());
    }

    @Test
    void testGetMovieByIdNotFound() {
        when(movieRepository.findById(99))
                .thenReturn(Optional.empty());

        assertThrows(MovieNotFoundException.class, () ->
                movieService.getById(99)
        );
    }

    @Test
    void testCreateMovie() {
        Movie movie = new Movie("The Dark Knight", "Christopher Nolan", 2008, "Action");

        when(movieRepository.save(any(Movie.class)))
                .thenReturn(movie);

        Movie saved = movieService.create(movie);

        assertEquals("The Dark Knight", saved.getTitle());
        verify(movieRepository).save(movie);
    }

    @Test
    void testDeleteMovieSuccess() {
        when(movieRepository.existsById(1))
                .thenReturn(true);

        movieService.delete(1);

        verify(movieRepository).deleteById(1);
    }
}