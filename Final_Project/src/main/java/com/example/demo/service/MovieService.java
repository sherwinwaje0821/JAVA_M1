package com.example.demo.service;

import com.example.demo.dao.Movie;
import com.example.demo.repository.MovieRepository;
import com.example.demo.exception.MovieNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

	private static final Logger log = LoggerFactory.getLogger(MovieService.class);

	private final MovieRepository movieRepository;

	public MovieService(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	public List<Movie> getAll() {
		log.info("Fetching all movies");
		return movieRepository.findAll();
	}

	public Movie getById(int id) {
		log.info("Fetching movie with id: {}", id);
		return movieRepository.findById(id).orElseThrow(() -> new MovieNotFoundException(id));
	}

	public Movie create(Movie movie) {
		log.info("Creating movie: {}", movie.getTitle());
		return movieRepository.save(movie);
	}

	public void delete(int id) {
		log.warn("Deleting movie with id: {}", id);
		if (!movieRepository.existsById(id)) {
			throw new MovieNotFoundException(id);
		}
		movieRepository.deleteById(id);
	}

}