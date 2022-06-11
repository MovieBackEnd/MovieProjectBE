package com.project.movie.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "MOVIE")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MOVIE_ID")
    private Long movie_id; //pk
    private String movie_name; //영화제목
    private String actor; //배우
    private int runtime; //런타임
    private Date release_date; //개봉일

    @Enumerated(EnumType.STRING)
    private Genre genre;

    @Enumerated(EnumType.STRING)
    private ScreenGrade screenGrade;

    @OneToMany(mappedBy = "movie_id")
    List<Reserve> reserve = new ArrayList<>();

    @OneToMany(mappedBy = "screen_id")
    List<Screen> screen = new ArrayList<>();
}
