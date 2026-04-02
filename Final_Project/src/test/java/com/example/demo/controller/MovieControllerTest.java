package com.example.demo.controller;

import com.example.demo.dao.Movie;
import com.example.demo.service.MovieService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MovieController.class)
class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MovieService movieService;

    @Autowired
    private ObjectMapper objectMapper;

    // ---------------------------
    // TEST: GET ALL MOVIES
    // ---------------------------
    @Test
    void testGetAllMovies() throws Exception {

        Movie movie = new Movie();
        movie.setId(1);
        movie.setTitle("Inception");
        movie.setDirector("Christopher Nolan");
        movie.setYear(2010);
        movie.setGenre("Sci-Fi");

        when(movieService.getAll()).thenReturn(List.of(movie));

        mockMvc.perform(get("/api/v1/movies/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Inception"));
    }

    // ---------------------------
    // TEST: CREATE MOVIE
    // ---------------------------
    @Test
    void testCreateMovie() throws Exception {

        Movie savedMovie = new Movie();
        savedMovie.setId(1);
        savedMovie.setTitle("Interstellar");
        savedMovie.setDirector("Christopher Nolan");
        savedMovie.setYear(2014);
        savedMovie.setGenre("Sci-Fi");

        when(movieService.create(org.mockito.ArgumentMatchers.any(Movie.class)))
                .thenReturn(savedMovie);

        String requestBody = """
            {
              "title": "Interstellar",
              "director": "Christopher Nolan",
              "year": 2014,
              "genre": "Sci-Fi"
            }
        """;

        mockMvc.perform(post("/api/v1/movies")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value("Interstellar"))
                .andExpect(jsonPath("$.director").value("Christopher Nolan"));
    }
}