package com.project.movie.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.movie.entity.Movie;
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
public class ScreenForm {
    private Long screen_id;
    @NotNull
    private LocalDateTime screenTime;
    @NotNull
    private Long movieId;
    @NotNull
    private Long screenTheaterId;

}
