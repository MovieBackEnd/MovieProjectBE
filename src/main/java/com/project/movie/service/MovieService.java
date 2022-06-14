package com.project.movie.service;

import com.project.movie.dto.MovieDTO;
import com.project.movie.dto.MovieSearch;
import com.project.movie.entity.Movie;
import com.project.movie.entity.QMovie;
import com.project.movie.repository.MovieRepository;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.AllArgsConstructor;
import org.eclipse.jdt.internal.compiler.lookup.IQualifiedTypeResolutionListener;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    @Transactional
    public MovieDTO createMovie(MovieDTO movieDTO) {
        Movie movie = movieDTO.toEntity();
        MovieDTO save = new MovieDTO(movieRepository.save(movie));
        return save;
    }

    @Transactional
    public MovieDTO updateMovie(Long movie_id, MovieDTO movieDTO) {
        Movie findMovie = movieRepository.findById(movie_id).get();
        if (findMovie != null) {
            findMovie.setMovieId(movie_id);
            findMovie.setMovieName(movieDTO.getMovie_name());
            findMovie.setActor(movieDTO.getActor());
            findMovie.setRuntime(movieDTO.getRuntime());
            findMovie.setRelease_date(movieDTO.getRelease_date());
            findMovie.setGenre(movieDTO.getGenre());
            findMovie.setScreenGrade(movieDTO.getScreenGrade());
            findMovie.setUrl(movieDTO.getUrl());
            findMovie.setTicketRating(movieDTO.getTicketRating());
            findMovie.setReviewRating(movieDTO.getReviewRating());
            findMovie.setDirector(movieDTO.getDirector());
        }
        MovieDTO updateMovie = new MovieDTO(movieRepository.save(findMovie));
        return updateMovie;
    }

    public MovieDTO findByMovieIdDetail(Long movie_id) {
        return new MovieDTO(movieRepository.findById(movie_id).get());
    }

    @Transactional
    public void deleteMovie(Long movie_id) {
        movieRepository.deleteById(movie_id);
    }

    public List<MovieDTO> findAllMovie() {
        List<Movie> movies = movieRepository.findAll();
        List<MovieDTO> movieDTOList = movies.stream().map(movie -> {
            return new MovieDTO(movie);
        }).collect(Collectors.toList());
        return movieDTOList;
    }

    public Page<Movie> findAllMovie_PageNation(Pageable pageable) {
        Page<Movie> page = movieRepository.findAll(pageable);
        page.stream().map(movie -> {
            return movie;
        });
        return page;
    }

    // 영화제목, 배우
    public List<Movie> findAllMovie(MovieSearch movieSearch) {
        return movieRepository.findAllMovie(movieSearch);
    }

    public List<Movie> findAllMovie2(String keyword) {
        return movieRepository.findByMovieNameContainingOrActorContaining(keyword, keyword);
    }

    // 예매율순
    public List<Movie> findAllMovieOrderByTicketRating() {
        return movieRepository.findAllByOrderByTicketRatingDesc();
    }

    public List<Movie> findAllMovieOrderByReviewRating() {
        return movieRepository.findAllByOrderByReviewRatingDesc();
    }

}
