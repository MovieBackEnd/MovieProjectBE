package com.project.movie.dto;

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
public class ScreenTheaterForm {
    private Long screenTheater_id;
    private Long theater_id;
    private ScreenTheaterName screenTheaterName;
}
