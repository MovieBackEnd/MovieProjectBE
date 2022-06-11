package com.project.movie.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@Table(name = "THEATER")
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "THEATER_ID")
    private Long theater_id;

    @JsonIgnore
    @OneToMany(mappedBy = "screenTheater_id",cascade = CascadeType.ALL)
    List<ScreenTheater> screenTheater = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private TheaterName theaterName;

}
