package com.project.movie.dto;

import com.project.movie.entity.Genre;
import com.project.movie.entity.Movie;
import com.project.movie.entity.ScreenGrade;
import com.sun.istack.NotNull;
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
    @NotNull
    private String movie_name; //영화제목
    @NotNull
    private String actor; //배우
    @NotNull
    private int runtime; //런타임
    @NotNull
    private Date release_date; //개봉일
    @NotNull
    private Genre genre;
    @NotNull
    private ScreenGrade screenGrade;

    private  String url;

    private Double ticketRating;
    private Double reviewRating;
    private String director;

    public MovieDTO(Movie movie){
        this.movie_id = movie.getMovieId();
        this.movie_name = movie.getMovieName();
        this.actor = movie.getActor();
        this.runtime = movie.getRuntime();
        this.release_date = movie.getRelease_date();
        this.genre = movie.getGenre();
        this.screenGrade = movie.getScreenGrade();
        this.url = movie.getUrl();
        this.ticketRating = movie.getTicketRating();
        this.reviewRating = movie.getReviewRating();
        this.director = movie.getDirector();
    }
    public Movie toEntity(){
        return new Movie(movie_id,movie_name,actor,runtime,release_date,genre,screenGrade,url,ticketRating,reviewRating,director,null);
    }
}
