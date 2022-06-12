package com.project.movie.repository;

import com.project.movie.dto.MovieSearch;
import com.project.movie.entity.Movie;

import java.util.List;

public interface MovieRepositoryCustom {
    public List<Movie> findAllMovie(MovieSearch movieSearch);
}
