package com.project.movie.dto;

import com.project.movie.entity.FeePolicy;
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
public class SeatResponseDTO {
    private Long seat_id; //pk
    private String data; //좌석번호
    private boolean unused; //예매여부
    private Integer seatPrice;


    public SeatResponseDTO(Seat seat){
        this.seat_id = seat.getSeatId();
        this.data = String.valueOf(seat.getSeatNum());
        this.unused = seat.isReserve();
    }

    public SeatResponseDTO(Seat seat, Integer seatPrice){
        this.seat_id = seat.getSeatId();
        this.data = String.valueOf(seat.getSeatNum());
        this.unused = seat.isReserve();
        this.seatPrice = seatPrice;
    }

//    public Seat toEntity() {
//        return new Seat(seat_id, data, unused, null);
//    }
}
