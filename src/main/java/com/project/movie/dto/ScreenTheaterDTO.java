package com.project.movie.dto;


import com.project.movie.entity.ScreenTheater;
import com.project.movie.entity.ScreenTheaterName;
import com.project.movie.entity.Theater;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ScreenTheaterDTO {
    private Long screenTheater_id;
    private Theater theater;
    private ScreenTheaterName screenTheaterName;

    public ScreenTheaterDTO(ScreenTheater screenTheater) {
        this.screenTheater_id = screenTheater.getScreenTheater_id();
        this.theater = screenTheater.getTheater();
        this.screenTheaterName = screenTheater.getScreenTheaterName();
    }

    public ScreenTheater toEntity() {
        return new ScreenTheater(screenTheater_id, theater, screenTheaterName
                , null);
    }
}
