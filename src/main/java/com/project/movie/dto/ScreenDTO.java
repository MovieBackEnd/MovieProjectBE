package com.project.movie.dto;

import com.project.movie.entity.Movie;
import com.project.movie.entity.Screen;
import com.project.movie.entity.ScreenTheater;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ScreenDTO {
    private Long screen_id;
    @NotNull
    private LocalDateTime screenTime;
    @NotNull
    private Movie movie;
    @NotNull
    private ScreenTheater screenTheater;

    public ScreenDTO(Screen screen){
        this.screen_id = screen.getScreen_id();
        this.screenTime = screen.getScreenTime();
        this.movie = screen.getMovie();
        this.screenTheater = screen.getScreenTheater();
    }

    public Screen toEntity() {
        return new Screen(screen_id,screenTime,movie,screenTheater,null,null);
    }
}
