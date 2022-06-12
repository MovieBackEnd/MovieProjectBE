package com.project.movie.repository;

import com.project.movie.dto.MovieSearch;
import com.project.movie.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long>, MovieRepositoryCustom {
    Page<Movie> findAll(Pageable pageable);
}
