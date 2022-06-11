package com.project.movie.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "SCREEN")
public class Screen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SCREEN_ID")
    private Long screen_id; //pk

    private Date screen_time;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MOVIE_ID")
    private Movie movie_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SCREEN_THEATER_ID")
    private ScreenTheater screenTheater_id;

    @OneToMany(mappedBy = "screen_id",cascade = CascadeType.ALL)
    List<Seat> seat = new ArrayList<>();

}