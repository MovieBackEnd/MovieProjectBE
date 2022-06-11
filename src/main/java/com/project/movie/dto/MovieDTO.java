package com.project.movie.dto;

import com.project.movie.entity.Genre;
import com.project.movie.entity.Movie;
import com.project.movie.entity.ScreenGrade;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO {
    private Long movie_id; //pk
    private String movie_name; //영화제목
    private String actor; //배우
    private int runtime; //런타임
    private Date release_date; //개봉일
    private Genre genre;
    private ScreenGrade screenGrade;

    public MovieDTO(Movie movie){
        this.movie_id = movie.getMovie_id();
        this.movie_name = movie.getMovie_name();
        this.actor = movie.getActor();
        this.runtime = movie.getRuntime();
        this.release_date = movie.getRelease_date();
        this.genre = movie.getGenre();
        this.screenGrade = movie.getScreenGrade();
    }
    public Movie toEntity(){
        return new Movie(movie_id,movie_name,actor,runtime,release_date,genre,screenGrade,null,null);
    }
}
