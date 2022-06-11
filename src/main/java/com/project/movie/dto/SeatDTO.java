package com.project.movie.dto;

import com.project.movie.entity.Screen;
import com.project.movie.entity.Seat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SeatDTO {
    private Long seat_id; //pk
    private Integer seat_num; //좌석번호
    private boolean isReserve; //예매여부
    private Screen screen;


    public SeatDTO(Seat seat){
        this.seat_id = seat.getSeatId();
        this.seat_num = seat.getSeatNum();
        this.isReserve = seat.isReserve();
        this.screen = seat.getScreenId();
    }

    public Seat toEntity() {
        return new Seat(seat_id, seat_num, isReserve, screen);
    }

}