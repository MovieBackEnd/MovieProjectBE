package com.project.movie.dto;

import com.project.movie.entity.Screen;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SeatForm {
    private Long seat_id; //pk
    private Integer seat_num; //좌석번호
    private boolean isReserve; //예매여부
    private Long screenId;
}
