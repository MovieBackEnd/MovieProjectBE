package com.project.movie.dto;


import com.project.movie.entity.Theater;
import com.project.movie.entity.TheaterName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TheaterDTO {
    private Long theater_id;
    private TheaterName theaterName;

    public TheaterDTO(Theater theater) {
        this.theater_id = theater.getTheater_id();
        this.theaterName = theater.getTheaterName();

    }

    public Theater toEntity() {
        return new Theater(theater_id, null, theaterName);
    }
}