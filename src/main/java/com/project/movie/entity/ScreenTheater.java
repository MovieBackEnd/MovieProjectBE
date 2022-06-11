package com.project.movie.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "SCREEN_THEATER")
public class ScreenTheater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SCREEN_THEATER_ID")
    private Long screenTheater_id; //pk

    @OneToMany(mappedBy = "screenTheater_id", cascade = CascadeType.ALL)
    List<Screen> screen = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "THEATER_ID")
    private Theater theater;

    @Enumerated(EnumType.STRING)
    private ScreenTheaterName screenTheaterName;

}