package com.project.movie.service;

import com.project.movie.dto.MovieDTO;
import com.project.movie.dto.UserDTO;
import com.project.movie.entity.Movie;
import com.project.movie.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public MovieDTO updateMovie(Long movie_id, MovieDTO movieDTO){
        Movie findMovie = movieRepository.findById(movie_id).get();
        if(findMovie != null){
            findMovie.setMovieName(movieDTO.getMovie_name());
            findMovie.setActor(movieDTO.getActor());
            findMovie.setRuntime(movieDTO.getRuntime());
            findMovie.setRelease_date(movieDTO.getRelease_date());
            findMovie.setGenre(movieDTO.getGenre());
            findMovie.setScreenGrade(movieDTO.getScreenGrade());
        }
        MovieDTO updateMovie = new MovieDTO(movieRepository.save(findMovie));
        return updateMovie;
    }

    @Transactional
    public void deleteMovie(Long movie_id){
        movieRepository.deleteById(movie_id);
    }

    public List<MovieDTO> findAllMovie() {
        List<Movie> movies = movieRepository.findAll();
        List<MovieDTO> movieDTOList = movies.stream().map(movie -> {
            return new MovieDTO(movie);
        }).collect(Collectors.toList());
        return movieDTOList;
    }

    public Page<Movie> findAllMovie_PageNation(Pageable pageable){
        Page<Movie> page = movieRepository.findAll(pageable);
        page.stream().map(movie -> {
            System.out.println(movie.getMovieName());
            return movie;
        });
        return page;
    }
}
